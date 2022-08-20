package com.yauhescha.javashiki.util;

import com.github.kevinsawicki.http.HttpRequest;
import com.yauhescha.javashiki.constant.ShikiInfo;
import com.yauhescha.javashiki.model.auth.AccessToken;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@RequiredArgsConstructor
public class RequestCreator {
    private final AccessToken accessToken;

    public HttpRequest buildHttpRequest(String url) {
        return HttpRequest
                .get(url)
                .userAgent(getUserAgentForHeader())
                .authorization(getAuthorizationForHeader());
    }

    public HttpRequest buildHttpRequest(String url, Map<String, Object> params) {
        return HttpRequest
                .get(url, true, getParams(params))
                .userAgent(getUserAgentForHeader())
                .authorization(getAuthorizationForHeader());
    }




    private String getAuthorizationForHeader() {
        return "Bearer " + accessToken.getAccessToken();
    }

    private String getUserAgentForHeader() {
        return ShikiInfo.APPLICATION_NAME;
    }

    private Object[] getParams(Map<String, Object> params) {
        ArrayList<Object> result = new ArrayList<>();
        params.forEach((k, v) -> {
            result.add(k);
            result.add(v);
        });
        return result.toArray(new Object[0]);
    }
}
