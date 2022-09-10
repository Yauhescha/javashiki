package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.UserApi;
import com.yauhescha.javashiki.model.domen.user.Favourity;
import com.yauhescha.javashiki.request.AuthShikimori;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final UserApi api = auth.getUserApi();
        Favourity favourities = api.getFavourities(1157416);

        System.out.println("auth");

    }
}
