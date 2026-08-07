package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Video;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class VideoApiTest extends CommonTestData {

    private boolean hasContentScope = false;

    @Before
    public void checkScope() {
        Map<String, Object> videoParams = new HashMap<>();
        videoParams.put("kind", "pv");
        videoParams.put("name", "Test Video");
        videoParams.put("url", "https://www.youtube.com/watch?v=dQw4w9WgXcQ");

        Video video = videoApi.createVideo(20, videoParams);
        hasContentScope = (video != null);
        if (hasContentScope) {
            videoApi.deleteVideo(20, video.getId());
        }
    }

    @Test
    public void getVideos() {
        List<Video> videos = videoApi.getVideos(20);
        assertNotNull(videos);
    }

    @Test
    public void createDeleteVideo() {
        Assume.assumeTrue("Token needs content scope", hasContentScope);
        Map<String, Object> videoParams = new HashMap<>();
        videoParams.put("kind", "pv");
        videoParams.put("name", "Test Video");
        videoParams.put("url", "https://www.youtube.com/watch?v=dQw4w9WgXcQ");

        Video video = videoApi.createVideo(20, videoParams);
        assertNotNull(video);

        if (video != null) {
            videoApi.deleteVideo(20, video.getId());
        }
    }
}
