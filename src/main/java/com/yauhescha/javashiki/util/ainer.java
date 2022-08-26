package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.Publisher;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Arrays;
import java.util.List;

public class ainer {
    public static void main(String[] args) {
//        new AuthShikimori().
        final List<Publisher> list = new AuthShikimori().getPublisherApi().getList();


        System.out.println(Arrays.toString(list.toArray()));

    }
}
