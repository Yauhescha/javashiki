package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Studio;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_STUDIOS_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class StudioApi {
    private final AuthShikimori auth;

    public List<Studio> getList() {
        Studio[] list = new ApiRequest<>(auth, Studio[].class)
                .execute(GET, METHOD_STUDIOS_GET);
        if (list == null) {
            return List.of();
        }
        return Arrays.asList(list);
    }
}
