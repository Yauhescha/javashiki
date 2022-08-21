package com.yauhescha.javashiki.util;

import com.github.kevinsawicki.http.HttpRequest;
import com.yauhescha.javashiki.constant.ShikiInfo;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.Map;

import static com.yauhescha.javashiki.constant.ShikiInfo.URL_API_V1;

@RequiredArgsConstructor
public class ApiRequest<T> {
    private final AuthShikimori authShikimori;
    protected final Class<T> responseType;

    public T execute(String url, Map<String, Object> params) {
        HttpRequest httpRequest = buildGetHttpRequest(URL_API_V1 + url, params);
        return Utils.fromJson(executeJSON(httpRequest), responseType);
    }

    public T execute(String url) {
        HttpRequest httpRequest = buildGetHttpRequest(URL_API_V1 + url, null);
        return Utils.fromJson(executeJSON(httpRequest), responseType);
    }

    private HttpRequest buildGetHttpRequest(String url, Map<String, Object> params) {
        HttpRequest request;
        if (params == null) {
            request = HttpRequest.get(url);
        } else {
            request = HttpRequest.get(url, true, getParams(params));
        }
        return request
                .userAgent(getUserAgentForHeader())
                .authorization(getAuthorizationForHeader());
    }

    protected String executeJSON(HttpRequest request) {
        val code = request.code();
        val json = request.body();
        System.out.println("Code: " + code);
        if (checkCode429(code)) return executeJSON(copyRequest(request));

        if (checkCode401(code)) return executeJSON(request);

        if(code == 404) {
            return null;
        }

        return json;
    }

    private HttpRequest copyRequest(HttpRequest request) {
        return HttpRequest
                .get(request.url())
                .userAgent(getUserAgentForHeader())
                .authorization(getAuthorizationForHeader());
    }

    private boolean checkCode401(int code) {
        if (code == 401) {
            if (!authShikimori.getAccessToken().isLoaded() || authShikimori.getAccessToken().isRefreshRequired()) {
                System.out.println("Token expired, trying refresh token...");
                authShikimori.initialAccessToken();
                return true;
            }
        }
        return false;
    }

    private boolean checkCode429(int code) {
        if (code == 429) {
            System.out.println("So many requests! Calming down...");
            try {
                Thread.sleep(1000);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }


    private String getAuthorizationForHeader() {
        return "Bearer " + authShikimori.getAccessToken().getAccessToken();
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
