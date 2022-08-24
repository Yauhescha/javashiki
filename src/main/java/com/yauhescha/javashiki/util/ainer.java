package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.Ban;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Arrays;
import java.util.List;

public class ainer {
    public static void main(String[] args) {
        final List<Ban> bans = new AuthShikimori().getBanApi().getBans();
        System.out.println(Arrays.toString(bans.toArray()));

    }
}
