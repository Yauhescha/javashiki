package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Ban;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_BANS_GET;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class BanApi {
    private final AuthShikimori auth;

    public List<Ban> getBans() {
        Ban[] bans = new ApiRequest<>(auth, Ban[].class)
                .execute(GET, METHOD_BANS_GET);
        if (bans == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(bans);
    }
}
