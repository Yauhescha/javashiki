package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Achievement;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ACHIEVEMETS_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class AchievementApi {
    private final AuthShikimori auth;
    private final String REQUEST_PARAMETER = "user_id";

    public List<Achievement> getAchievements(@NonNull int userId) {
        Achievement[] achievements = new ApiRequest<>(auth, Achievement[].class)
                .execute(GET, METHOD_ACHIEVEMETS_GET, Map.of(REQUEST_PARAMETER, userId));
        if (achievements == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(achievements);
    }
}
