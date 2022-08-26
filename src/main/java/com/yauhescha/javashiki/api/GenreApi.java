package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Genre;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_GENRES_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class GenreApi {
    private final AuthShikimori auth;

    public List<Genre> getList() {
        Genre[] list = new ApiRequest<>(auth, Genre[].class)
                .execute(GET, METHOD_GENRES_GET);
        if (list == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(list);
    }
}
