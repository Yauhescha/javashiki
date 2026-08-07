package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Review;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class ReviewApi {
    private final AuthShikimori auth;

    public Review createReview(Map<String, Object> reviewParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("review", reviewParams);
        return new ApiRequest<>(auth, Review.class)
                .execute(POST, METHOD_REVIEWS_GET, params);
    }

    public Review updateReview(long reviewId, Map<String, Object> reviewParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("review", reviewParams);
        return new ApiRequest<>(auth, Review.class)
                .execute(PATCH, String.format(METHOD_REVIEWS_GET_ID, reviewId), params);
    }

    public void deleteReview(long reviewId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_REVIEWS_GET_ID, reviewId));
    }
}
