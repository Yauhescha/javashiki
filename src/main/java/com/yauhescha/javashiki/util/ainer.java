package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.UserApi;
import com.yauhescha.javashiki.model.domen.user.History;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final UserApi api = auth.getUserApi();
        final List<History> histories = api.getHistories(1);

        System.out.println("auth");

    }
}
