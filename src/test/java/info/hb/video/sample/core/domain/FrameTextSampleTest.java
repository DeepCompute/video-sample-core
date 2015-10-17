package info.hb.video.sample.core.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrameTextSampleTest {

	@Test
	public void testFrameTextSample() {
		FrameTextSample frameTextSample = new FrameTextSample.Builder("123456789", "测试内容").setEdit_count(10)
				.setEdit_user_last("test_user").setEdit_users(",test_user1,test_user2").setFrame_index(11)
				.setFrame_url("http://baidu.com").setVideo_id(987654321).setVideo_name("测试视频").build();
		String result = "FrameTextSample{id=123456789, frame_content=测试内容, frame_index=11, frame_url=http://baidu.com, "
				+ "video_id=987654321, video_name=测试视频, edit_count=10, edit_users=,test_user1,test_user2, edit_user_last=test_user}";
		assertEquals(result, frameTextSample.toString());
		assertEquals("123456789", frameTextSample.getId());
		assertEquals("测试内容", frameTextSample.getFrame_content());
		assertEquals(11, frameTextSample.getFrame_index());
		assertEquals("http://baidu.com", frameTextSample.getFrame_url());
		assertEquals(987654321, frameTextSample.getVideo_id());
		assertEquals("测试视频", frameTextSample.getVideo_name());
		assertEquals(10, frameTextSample.getEdit_count());
		assertEquals(",test_user1,test_user2", frameTextSample.getEdit_users());
		assertEquals("test_user", frameTextSample.getEdit_user_last());
	}

}
