package info.hb.video.sample.core.domain;

import java.io.Serializable;

import com.google.common.base.MoreObjects;

/**
 * 视频帧样本描述信息
 *
 * @author wanggang
 *
 */
public class FrameTextSample implements Serializable {

	private static final long serialVersionUID = -4714528414624457466L;

	// 视频帧的唯一ID
	private String id;
	// 视频帧对应的文本描述内容
	private String frame_content;
	// 视频帧所在视频的索引
	private int frame_index;
	// 视频帧的存储地址
	private String frame_url;
	// 视频ID
	private long video_id;
	// 视频完整名称
	private String video_name;
	// 编辑次数
	private int edit_count;
	// 编辑用户，逗号分割
	private String edit_users;
	// 最后编辑用户
	private String edit_user_last;

	public FrameTextSample() {
	}

	public FrameTextSample(Builder builder) {
		this.id = builder.id;
		this.frame_content = builder.frame_content;
		this.frame_index = builder.frame_index;
		this.frame_url = builder.frame_url;
		this.video_id = builder.video_id;
		this.video_name = builder.video_name;
		this.edit_count = builder.edit_count;
		this.edit_users = builder.edit_users;
		this.edit_user_last = builder.edit_user_last;
	}

	public static class Builder {

		private final String id;
		private final String frame_content;
		private int frame_index;
		private String frame_url;
		private long video_id;
		private String video_name;
		private int edit_count;
		private String edit_users;
		private String edit_user_last;

		public Builder(String id, String frame_content) {
			this.id = id;
			this.frame_content = frame_content;
		}

		public Builder setFrame_index(int frame_index) {
			this.frame_index = frame_index;
			return this;
		}

		public Builder setFrame_url(String frame_url) {
			this.frame_url = frame_url;
			return this;
		}

		public Builder setVideo_id(long video_id) {
			this.video_id = video_id;
			return this;
		}

		public Builder setVideo_name(String video_name) {
			this.video_name = video_name;
			return this;
		}

		public Builder setEdit_count(int edit_count) {
			this.edit_count = edit_count;
			return this;
		}

		public Builder setEdit_users(String edit_users) {
			this.edit_users = edit_users;
			return this;
		}

		public Builder setEdit_user_last(String edit_user_last) {
			this.edit_user_last = edit_user_last;
			return this;
		}

		public FrameTextSample build() {
			return new FrameTextSample(this);
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrame_content() {
		return frame_content;
	}

	public void setFrame_content(String frame_content) {
		this.frame_content = frame_content;
	}

	public int getFrame_index() {
		return frame_index;
	}

	public void setFrame_index(int frame_index) {
		this.frame_index = frame_index;
	}

	public String getFrame_url() {
		return frame_url;
	}

	public void setFrame_url(String frame_url) {
		this.frame_url = frame_url;
	}

	public long getVideo_id() {
		return video_id;
	}

	public void setVideo_id(long video_id) {
		this.video_id = video_id;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public int getEdit_count() {
		return edit_count;
	}

	public void setEdit_count(int edit_count) {
		this.edit_count = edit_count;
	}

	public String getEdit_users() {
		return edit_users;
	}

	public void setEdit_users(String edit_users) {
		this.edit_users = edit_users;
	}

	public String getEdit_user_last() {
		return edit_user_last;
	}

	public void setEdit_user_last(String edit_user_last) {
		this.edit_user_last = edit_user_last;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", this.id).add("frame_content", this.frame_content)
				.add("frame_index", this.frame_index).add("frame_url", this.frame_url).add("video_id", this.video_id)
				.add("video_name", this.video_name).add("edit_count", this.edit_count)
				.add("edit_users", this.edit_users).add("edit_user_last", this.edit_user_last).toString();
	}

}
