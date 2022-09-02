package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.user.UserInfo;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Optional;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final Optional<UserInfo> userInfo = auth.getUserApi().findUserInfo(1);
        final UserInfo userInfo1 = auth.getUserApi().whoIAm();


        System.out.println("auth");

    }
}
