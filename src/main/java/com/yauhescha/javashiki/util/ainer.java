package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.ForumApi;
import com.yauhescha.javashiki.model.domen.Forum;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.Arrays;
import java.util.List;

public class ainer {
    public static void main(String[] args) {
//        new AuthShikimori().

        final ForumApi calendarApi = new AuthShikimori().getForumApi();
        final List<Forum> list = calendarApi.getForums();


        System.out.println(Arrays.toString(list.toArray()));

    }
}
