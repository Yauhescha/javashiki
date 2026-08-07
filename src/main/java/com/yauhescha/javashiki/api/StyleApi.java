package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Style;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class StyleApi {
    private final AuthShikimori auth;

    public Optional<Style> getStyle(long styleId) {
        Style style = new ApiRequest<>(auth, Style.class)
                .execute(GET, String.format(METHOD_STYLES_GET_ID, styleId));
        return Optional.ofNullable(style);
    }

    public Style previewStyle(String css) {
        Map<String, Object> styleParams = new HashMap<>();
        styleParams.put("css", css);
        Map<String, Object> params = new HashMap<>();
        params.put("style", styleParams);
        return new ApiRequest<>(auth, Style.class)
                .execute(POST, METHOD_STYLES_PREVIEW, params);
    }

    public Style createStyle(Map<String, Object> styleParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("style", styleParams);
        return new ApiRequest<>(auth, Style.class)
                .execute(POST, METHOD_STYLES_GET, params);
    }

    public Style updateStyle(long styleId, Map<String, Object> styleParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("style", styleParams);
        return new ApiRequest<>(auth, Style.class)
                .execute(PATCH, String.format(METHOD_STYLES_GET_ID, styleId), params);
    }
}
