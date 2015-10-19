package info.hb.video.sample.core.main;

import info.hb.riak.cluster.client.HBRiakClient;
import info.hb.riak.cluster.client.HBRiakClusterImpl;
import info.hb.video.model.name.VideoName;
import info.hb.video.sample.core.dao.FrameSample;
import info.hb.video.sample.core.domain.FrameTextSample;
import info.ub.video.sample.core.common.MybatisConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.video.Video;
import org.openimaj.video.xuggle.XuggleVideo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.utils.checksum.CheckSumUtils;
import zx.soft.utils.system.ProcessAnalysis;

public class KeyFramePersist {

	private static Logger logger = LoggerFactory.getLogger(KeyFramePersist.class);

	private static final String IMAGE_SUFFIX = "png";

	private static final String FRAMES_BUCKET_NAME = "frames";

	private static final String BUCKET_TYPE = "default";

	// Nginx代理服务器
	// 外网：36.7.150.150:9998
	// 内网：192.168.31.11:1888
	private static final String NGINX_PROXY = "192.168.31.11:1888";

	private static final AtomicInteger COUNT = new AtomicInteger(0);

	// 帧率，这里处理的视频帧率不同，25、30都有
	private int frameRate = 25;

	private HBRiakClient cluster;

	// 持久化到MySQL中
	private FrameSample frameSample;

	public KeyFramePersist(int frameRate) {
		frameSample = new FrameSample(MybatisConfig.ServerEnum.video);
		cluster = new HBRiakClusterImpl();
		this.frameRate = frameRate;
	}

	/**
	 * 主函数
	 */
	public static void main(String[] args) {
		KeyFramePersist kfp = new KeyFramePersist(50);
		kfp.run(new File("/home/wanggang/develop/deeplearning/xc-video-20150828"));
		kfp.close();
	}

	public void run(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				run(file);
			} else {
				// 存储视频到Riak中，然后需要存储到MySQL中的信息列表
				List<FrameTextSample> frameTextSamples = video2KeyFrames(file);
				// 存储到MySQL中
				try {
					frameSample.insertFrameSamples(frameTextSamples);
				} catch (Exception e) {
					//
				}
			}
		}
	}

	public List<FrameTextSample> video2KeyFrames(File file) {
		String videoFile = file.getAbsolutePath();
		String vname = videoFile.substring(videoFile.lastIndexOf("/") + 1);
		VideoName videoName;
		try {
			videoName = new VideoName(vname);
		} catch (Exception e) {
			logger.error("Count:{}, Video:'{}' type is error.", COUNT.addAndGet(1), vname);
			return null;
		}
		// 处理视频帧
		List<FrameTextSample> result = new ArrayList<>();
		try (Video<MBFImage> frames = new XuggleVideo(new File(videoFile));) {
			logger.info("Count:{}, Video:'{}' has {} frames, frame rate is {}.", COUNT.addAndGet(1), vname,
					frames.countFrames(), frames.getFPS());
			//			frameRate = (int) frames.getFPS();
			// 帧索引
			int index = 1;
			FrameTextSample frameTextSample = null;
			/*
			 *  封装当前视频帧
			 */
			for (MBFImage mbfImage : frames) {
				// 每帧率取1帧
				if ((index - 1) % frameRate != 0) {
					index++;
					continue;
				}
				// id是根据videoName+frame_index进行MD5得到的
				String id = CheckSumUtils.getMD5(vname + index);
				// 存储PNG到Riak
				cluster.writeImage(BUCKET_TYPE, FRAMES_BUCKET_NAME, id + "." + IMAGE_SUFFIX,
						ImageUtilities.createBufferedImageForDisplay(mbfImage), IMAGE_SUFFIX);
				// 存MySQL对象构建
				frameTextSample = new FrameTextSample.Builder(id, "").setEdit_count(0).setEdit_user_last("")
						.setEdit_users("").setFrame_index(index).setFrame_url(getFrameUrl(id))
						.setVideo_id(videoName.getVideo_id()).setVideo_name(vname).build();
				// 添加到列表中
				result.add(frameTextSample);
				// 输出测试
				System.err.println(index + ": " + id);
				index++;
			}
		}

		return result;
	}

	private String getFrameUrl(String imageId) {
		return "http://" + NGINX_PROXY + "/riak/" + FRAMES_BUCKET_NAME + "/" + imageId + "." + IMAGE_SUFFIX;
	}

	public void close() {
		// TS视频关闭不了，进程执行完需要强制关闭
		ProcessAnalysis.killPid(ProcessAnalysis.getCurrentPidByLang());
		logger.info("Closed this processor......");
	}

}
