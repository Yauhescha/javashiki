package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.CharacterFull;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final List<CharacterFull> search = auth.getCharacterApi().search("1");

        System.out.println(search);

    }
}
