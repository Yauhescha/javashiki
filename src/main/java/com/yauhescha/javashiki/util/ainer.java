package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.UserApi;
import com.yauhescha.javashiki.model.domen.Ban;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Arrays;
import java.util.List;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final UserApi api = auth.getUserApi();
        for(int i=0; i<10; i++) {
            System.out.println("id " + i);
            final List<Ban> bans = api.getBans(i);
            final String s = Arrays.toString(bans.toArray());
            System.out.println(s);
            System.out.println();
        }

        System.out.println("auth");

    }
}
