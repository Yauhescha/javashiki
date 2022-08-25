package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Forum;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_FORUMS_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class ForumApi {
    private final AuthShikimori auth;

    public List<Forum> getForums() {
        Forum[] forums = new ApiRequest<>(auth, Forum[].class)
                .execute(GET, METHOD_FORUMS_GET);
        if (forums == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(forums);
    }
}
