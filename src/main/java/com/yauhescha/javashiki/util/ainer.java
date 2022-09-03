package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.UserApi;
import com.yauhescha.javashiki.model.domen.user.UnreadMessages;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Optional;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final UserApi api = auth.getUserApi();
        final Optional<UnreadMessages> unreadMessages = api.findUnreadMessages(1);

        System.out.println("auth");

    }
}
