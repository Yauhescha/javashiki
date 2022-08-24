package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Map;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_APPEARS_POST;
import static com.yauhescha.javashiki.request.RequestType.POST;

@RequiredArgsConstructor
public class AppearsApi {
    private final AuthShikimori auth;
    private final String POST_PARAMETER = "ids";

    public void postAppears(String... ids) {
        String appearsParamsAsString = String.join(",", ids);
        new ApiRequest<>(auth, Object.class)
                .execute(POST, METHOD_APPEARS_POST, Map.of(POST_PARAMETER, appearsParamsAsString));
    }
}
