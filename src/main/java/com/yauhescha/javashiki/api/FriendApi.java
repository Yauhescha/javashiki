package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_FRIENDS_CREATE;
import static com.yauhescha.javashiki.request.RequestType.DELETE;
import static com.yauhescha.javashiki.request.RequestType.POST;

@RequiredArgsConstructor
public class FriendApi {
    private final AuthShikimori auth;

    public void addFriend(long userId) {
        new ApiRequest<>(auth, Object.class)
                .execute(POST, String.format(METHOD_FRIENDS_CREATE, userId));
    }

    public void removeFriend(long userId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_FRIENDS_CREATE, userId));
    }
}
