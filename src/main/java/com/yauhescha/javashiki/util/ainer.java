package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.People;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;

public class ainer {
    public static void main(String[] args) {

        final List<People> a = new AuthShikimori().getPeopleApi().search("a");
        System.out.println(a);

    }
}
