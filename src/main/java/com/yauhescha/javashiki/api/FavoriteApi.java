package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class FavoriteApi {
    private final AuthShikimori auth;

    public void createFavorite(String linkedType, long linkedId) {
        createFavorite(linkedType, linkedId, null);
    }

    public void createFavorite(String linkedType, long linkedId, String kind) {
        String url;
        if (kind != null) {
            url = String.format("/favorites/%s/%s/%s", linkedType, linkedId, kind);
        } else {
            url = String.format(METHOD_FAVORITES_CREATE, linkedType, linkedId);
        }
        new ApiRequest<>(auth, Object.class)
                .execute(POST, url);
    }

    public void destroyFavorite(String linkedType, long linkedId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_FAVORITES_DESTROY, linkedType, linkedId));
    }

    public void reorderFavorite(long favoriteId, int newIndex) {
        Map<String, Object> params = new HashMap<>();
        params.put("new_index", newIndex);
        new ApiRequest<>(auth, Object.class)
                .execute(POST, String.format(METHOD_FAVORITES_REORDER, favoriteId), params);
    }
}
