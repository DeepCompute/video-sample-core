package info.hb.video.sample.core.dao;

import info.hb.video.sample.core.domain.FrameTextSample;
import info.ub.video.sample.core.common.MybatisConfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.utils.log.LogbackUtil;

/**
 * 专题信息查询缓存类
 *
 * @author wanggang
 *
 */
public class FrameSample {

	private static Logger logger = LoggerFactory.getLogger(FrameSample.class);

	private static SqlSessionFactory sqlSessionFactory;

	public FrameSample(MybatisConfig.ServerEnum server) {
		try {
			sqlSessionFactory = MybatisConfig.getSqlSessionFactory(server);
		} catch (RuntimeException e) {
			logger.error("Exception:{}", LogbackUtil.expection2Str(e));
			throw new RuntimeException(e);
		}
	}

	/**
	 * 插入关键帧信息
	 */
	public void insertFrameSample(FrameTextSample frameTextSample) {
		try (SqlSession session = sqlSessionFactory.openSession();) {
			FrameSampleMapper frameSampleMapper = session.getMapper(FrameSampleMapper.class);
			frameSampleMapper.insertFrameSample(frameTextSample);
			session.commit();
		}
	}

	public void insertFrameSamples(List<FrameTextSample> frameTextSamples) {
		for (FrameTextSample frameTextSample : frameTextSamples) {
			insertFrameSample(frameTextSample);
		}
	}

	/**
	 * 删除关键帧信息
	 */
	public void deleteFrameSample(String id) {
		try (SqlSession session = sqlSessionFactory.openSession();) {
			FrameSampleMapper frameSampleMapper = session.getMapper(FrameSampleMapper.class);
			frameSampleMapper.deleteFrameSample(id);
			session.commit();
		}
	}

	/**
	 * 查询关键帧信息，根据编辑次数查询关键帧 [low,high]
	 */
	public List<FrameTextSample> selectFrameSamples(int low, int high) {
		try (SqlSession session = sqlSessionFactory.openSession();) {
			FrameSampleMapper frameSampleMapper = session.getMapper(FrameSampleMapper.class);
			return frameSampleMapper.selectFrameSamples(low, high);
		}
	}

	/**
	 * 查询关键帧信息，根据编辑人查询关键帧
	 */
	public List<FrameTextSample> selectFrameSamplesLikeUser(String user) {
		try (SqlSession session = sqlSessionFactory.openSession();) {
			FrameSampleMapper frameSampleMapper = session.getMapper(FrameSampleMapper.class);
			return frameSampleMapper.selectFrameSamplesLikeUser(user);
		}
	}

	/**
	 * 查询关键帧信息，根据最后编辑人查询关键帧
	 */
	public List<FrameTextSample> selectFrameSamplesLastUser(String user) {
		try (SqlSession session = sqlSessionFactory.openSession();) {
			FrameSampleMapper frameSampleMapper = session.getMapper(FrameSampleMapper.class);
			return frameSampleMapper.selectFrameSamplesLastUser(user);
		}
	}

	/**
	 * 查询关键帧信息，根据最后编辑人（不包含该人）和查询次数查询关键帧
	 */
	public List<FrameTextSample> selectFrameSamplesLastUserEditCount(String user, int low, int high) {
		try (SqlSession session = sqlSessionFactory.openSession();) {
			FrameSampleMapper frameSampleMapper = session.getMapper(FrameSampleMapper.class);
			return frameSampleMapper.selectFrameSamplesLastUserEditCount(user, low, high);
		}
	}

	/**
	 * 更改关键帧信息，更改关键帧内容、编辑次数、编辑人和时间
	 */
	public void updateFrameSample(String id, String frameContent, String user) {
		try (SqlSession session = sqlSessionFactory.openSession();) {
			FrameSampleMapper frameSampleMapper = session.getMapper(FrameSampleMapper.class);
			frameSampleMapper.updateFrameSample(id, frameContent, user);
			session.commit();
		}
	}

}
