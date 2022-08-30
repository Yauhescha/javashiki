package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.reques.ImageResponse;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.File;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USER_IMAGE_POST;

@RequiredArgsConstructor
public class UserImageApi {
    private final AuthShikimori auth;

    public ImageResponse postImage(@NonNull File image) {
        return new ApiRequest<>(auth, ImageResponse.class)
                .executePostImage(METHOD_USER_IMAGE_POST, image);
    }
}
