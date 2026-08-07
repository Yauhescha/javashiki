package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Video;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class VideoApi {
    private final AuthShikimori auth;

    public List<Video> getVideos(int animeId) {
        Video[] videos = new ApiRequest<>(auth, Video[].class)
                .execute(GET, String.format(METHOD_VIDEOS_GET, animeId));
        if (videos == null) {
            return List.of();
        }
        return Arrays.asList(videos);
    }

    public Video createVideo(int animeId, Map<String, Object> videoParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("video", videoParams);
        return new ApiRequest<>(auth, Video.class)
                .execute(POST, String.format(METHOD_VIDEOS_GET, animeId), params);
    }

    public void deleteVideo(int animeId, long videoId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_VIDEOS_GET_ID, animeId, videoId));
    }
}
