package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Notice;
import com.yauhescha.javashiki.model.domen.UserRate;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class UserRateApi {
    private final AuthShikimori auth;

    public Optional<UserRate> getUserRate(long userRateId) {
        UserRate userRate = new ApiRequest<>(auth, UserRate.class)
                .execute(GET, String.format(METHOD_USER_RATES_GET_ID, userRateId));
        return Optional.ofNullable(userRate);
    }

    public UserRate createUserRate(Map<String, Object> userRateParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_rate", userRateParams);
        return new ApiRequest<>(auth, UserRate.class)
                .execute(POST, METHOD_USER_RATES_GET, params);
    }

    public UserRate updateUserRate(long userRateId, Map<String, Object> userRateParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_rate", userRateParams);
        return new ApiRequest<>(auth, UserRate.class)
                .execute(PATCH, String.format(METHOD_USER_RATES_GET_ID, userRateId), params);
    }

    public UserRate incrementUserRate(long userRateId) {
        return new ApiRequest<>(auth, UserRate.class)
                .execute(POST, String.format(METHOD_USER_RATES_INCREMENT, userRateId));
    }

    public void deleteUserRate(long userRateId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_USER_RATES_GET_ID, userRateId));
    }

    public Notice cleanupUserRates(String type) {
        return new ApiRequest<>(auth, Notice.class)
                .execute(DELETE, String.format(METHOD_USER_RATES_CLEANUP, type));
    }

    public Notice resetUserRates(String type) {
        return new ApiRequest<>(auth, Notice.class)
                .execute(DELETE, String.format(METHOD_USER_RATES_RESET, type));
    }
}
