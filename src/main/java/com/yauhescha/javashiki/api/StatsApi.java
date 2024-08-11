package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_STATS_ACTIVE_USER_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class StatsApi {
    private final AuthShikimori auth;

    public List<Long> getList() {
        Long[] list = new ApiRequest<>(auth, Long[].class)
                .execute(GET, METHOD_STATS_ACTIVE_USER_GET);
        if (list == null) {
            return List.of();
        }
        return Arrays.asList(list);
    }
}
