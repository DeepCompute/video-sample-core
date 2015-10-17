package info.hb.video.sample.core.dao;

import info.hb.video.sample.core.domain.FrameTextSample;
import info.ub.video.sample.core.common.MybatisConfig;

public class FrameSampleDemo {

	public static void main(String[] args) {
		FrameSample frameSample = new FrameSample(MybatisConfig.ServerEnum.video);
		FrameTextSample frameTextSample = new FrameTextSample.Builder("1234567245", "测试内容").setEdit_count(2)
				.setEdit_user_last("test_user").setEdit_users(",test_user1,test_user2").setFrame_index(11)
				.setFrame_url("http://baidu.com").setVideo_id(987654321).setVideo_name("测试视频").build();
		// 插入关键帧信息
		frameSample.insertFrameSample(frameTextSample);
		// 删除关键帧信息
		//		frameSample.deleteFrameSample("123456789");
		// 查询关键帧信息，根据编辑次数查询关键帧
		//		System.out.println(JsonUtils.toJson(frameSample.selectFrameSamples(3, 3)));
		// 查询关键帧信息，根据编辑人查询关键帧
		//		System.out.println(JsonUtils.toJson(frameSample.selectFrameSamplesLikeUser("test")));
		// 查询关键帧信息，根据最后编辑人查询关键帧
		//		System.out.println(JsonUtils.toJson(frameSample.selectFrameSamplesLastUser("test_user")));
		// 查询关键帧信息，根据最后编辑人（不包含该人）和查询次数查询关键帧
		//		System.out.println(JsonUtils.toJson(frameSample.selectFrameSamplesLastUserEditCount("test_user1", 3, 4)));
		// 更改关键帧信息，更改关键帧内容、编辑次数、编辑人和时间
		//		frameSample.updateFrameSample("123456789","再次编辑", "wgybzb");
	}

}
