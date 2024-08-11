package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Publisher;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_PUBLISHERS_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class PublisherApi {
    private final AuthShikimori auth;

    public List<Publisher> getList() {
        Publisher[] list = new ApiRequest<>(auth, Publisher[].class)
                .execute(GET, METHOD_PUBLISHERS_GET);
        if (list == null) {
            return List.of();
        }
        return Arrays.asList(list);
    }
}
