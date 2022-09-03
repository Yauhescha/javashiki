package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.UserApi;
import com.yauhescha.javashiki.model.domen.user.Club;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final UserApi api = auth.getUserApi();
        final List<Club> clubs = api.getClubs(1);

        System.out.println("auth");

    }
}
