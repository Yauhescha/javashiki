package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.user.UserFull;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;
import java.util.Optional;

public class ainer {
    public static void main(String[] args) {

        final AuthShikimori auth = new AuthShikimori();
        final List<User> users = auth.getUserApi().getUsers(1, 3);
        final Optional<UserFull> userById = auth.getUserApi().findUserById(1);


        System.out.println("auth");

    }
}
