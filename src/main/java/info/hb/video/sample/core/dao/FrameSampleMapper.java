package info.hb.video.sample.core.dao;

import info.hb.video.sample.core.domain.FrameTextSample;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FrameSampleMapper {

	/**
	 * 插入关键帧信息
	 */
	@Insert("INSERT INTO `frame_text_samples` (`id`,`frame_content`,`frame_index`,`frame_url`,`video_id`,`video_name`,"
			+ "`edit_count`,`edit_users`,`edit_user_last`,`lasttime`) VALUES (#{id},#{frame_content},#{frame_index},"
			+ "#{frame_url},#{video_id},#{video_name},#{edit_count},#{edit_users},#{edit_user_last},NOW())")
	public void insertFrameSample(FrameTextSample frameTextSample);

	/**
	 * 删除关键帧信息
	 */
	@Delete("DELETE FROM `frame_text_samples` WHERE `id` = #{0}")
	public void deleteFrameSample(String id);

	/**
	 * 查询关键帧信息，根据编辑次数查询关键帧
	 */
	@Select("SELECT `id`,`frame_content`,`frame_index`,`frame_url`,`video_id`,`video_name`,`edit_count`,`edit_users`,"
			+ "`edit_user_last` FROM `frame_text_samples` WHERE `edit_count` BETWEEN #{0} AND #{1} ORDER BY `edit_count`")
	public List<FrameTextSample> selectFrameSamples(int low, int high);

	/**
	 * 查询关键帧信息，根据编辑人查询关键帧
	 */
	@Select("SELECT `id`,`frame_content`,`frame_index`,`frame_url`,`video_id`,`video_name`,`edit_count`,`edit_users`,"
			+ "`edit_user_last` FROM `frame_text_samples` WHERE `edit_users` LIKE CONCAT(\"%\",#{0},\"%\")")
	public List<FrameTextSample> selectFrameSamplesLikeUser(String user);

	/**
	 * 查询关键帧信息，根据最后编辑人查询关键帧
	 */
	@Select("SELECT `id`,`frame_content`,`frame_index`,`frame_url`,`video_id`,`video_name`,`edit_count`,`edit_users`,"
			+ "`edit_user_last` FROM `frame_text_samples` WHERE `edit_user_last` = #{0}")
	public List<FrameTextSample> selectFrameSamplesLastUser(String user);

	/**
	 * 查询关键帧信息，根据最后编辑人和查询次数查询关键帧
	 */
	@Select("SELECT `id`,`frame_content`,`frame_index`,`frame_url`,`video_id`,`video_name`,`edit_count`,`edit_users`,"
			+ "`edit_user_last` FROM `frame_text_samples` WHERE `edit_user_last` != #{0} AND `edit_count` BETWEEN #{1}"
			+ " AND #{2} ORDER BY `edit_count`")
	public List<FrameTextSample> selectFrameSamplesLastUserEditCount(String user, int low, int high);

	/**
	 * 更改关键帧信息，更改关键帧内容、编辑次数、编辑人和时间
	 */
	@Update("UPDATE `frame_text_samples` SET `frame_content` = CONCAT(`frame_content`,\";\",#{1}), `edit_count` ="
			+ " `edit_count` + 1, `edit_users` = CONCAT(`edit_users`,\";\",#{2}), `edit_user_last` = #{2}, `lasttime`"
			+ " = NOW() WHERE `id` = #{0}")
	public void updateFrameSample(String id, String frameContent, String user);

}
