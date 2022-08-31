package com.yauhescha.javashiki.util;

import com.github.kevinsawicki.http.HttpRequest;
import lombok.experimental.UtilityClass;

import static com.yauhescha.javashiki.constant.ShikiInfo.GRANT_TYPE_AUTHORIZATION_CODE;
import static com.yauhescha.javashiki.constant.ShikiInfo.GRANT_TYPE_REFRESH_TOKEN;
import static com.yauhescha.javashiki.constant.ShikiInfo.PARAM_CLIENT_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.PARAM_CLIENT_SECRET;
import static com.yauhescha.javashiki.constant.ShikiInfo.PARAM_CODE;
import static com.yauhescha.javashiki.constant.ShikiInfo.PARAM_GRANT_TYPE;
import static com.yauhescha.javashiki.constant.ShikiInfo.PARAM_REDIRECT_URI;
import static com.yauhescha.javashiki.constant.ShikiInfo.PARAM_REFRESH_TOKEN;
import static com.yauhescha.javashiki.constant.ShikiInfo.PARAM_RESPONSE_TYPE;
import static com.yauhescha.javashiki.constant.ShikiInfo.RESPONSE_TYPE_CODE;
import static com.yauhescha.javashiki.constant.ShikiInfo.URL_AUTHORIZE;
import static com.yauhescha.javashiki.constant.ShikiInfo.URL_TOKEN;

@UtilityClass
public class AuthMethodCreator {
    public HttpRequest createCodeRequest(String clientId, String clientSecret,
                                         String redirectUri) {
        return HttpRequest.get(URL_AUTHORIZE, true, PARAM_CLIENT_ID, clientId, PARAM_CLIENT_SECRET, clientSecret,
                PARAM_REDIRECT_URI, redirectUri, PARAM_RESPONSE_TYPE, RESPONSE_TYPE_CODE);
    }

    public HttpRequest createAuthorizationTokenRequest(String clientId, String clientSecret,
                                                       String redirectUri, String code,
                                                       String appName) {
        return HttpRequest.post(URL_TOKEN, true, PARAM_CLIENT_ID, clientId, PARAM_CLIENT_SECRET, clientSecret,
                        PARAM_REDIRECT_URI, redirectUri, PARAM_GRANT_TYPE, GRANT_TYPE_AUTHORIZATION_CODE, PARAM_CODE, code)
                .userAgent(appName);
    }

    public HttpRequest createRefreshTokenRequest(String clientId, String clientSecret,
                                                 String appName, String refreshToken) {
        return HttpRequest.post(URL_TOKEN, true, PARAM_GRANT_TYPE, GRANT_TYPE_REFRESH_TOKEN, PARAM_REFRESH_TOKEN,
                refreshToken, PARAM_CLIENT_SECRET, clientSecret, PARAM_CLIENT_ID, clientId).userAgent(appName);
    }
}
