package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.People;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Optional;

public class ainer {
    public static void main(String[] args) {

//        final PeopleApi peopleApi = new AuthShikimori().getPeopleApi();
        final Optional<People> byId = new AuthShikimori().getPeopleApi().findById(1);
        System.out.println(byId);

    }
}
