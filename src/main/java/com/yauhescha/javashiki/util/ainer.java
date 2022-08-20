package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.auth.AccessToken;
import com.yauhescha.javashiki.model.domen.AnimeFull;

public class ainer {
    public static void main(String[] args) throws Exception {
        AuthShikimori authShikimori = new AuthShikimori();
        AccessToken accessToken = authShikimori.initialAccessToken();


        for(int i=1; i<200; i++){

            AnimeFull animeDetail = authShikimori.getAnimeApi().getAnimeDetail(i);

            System.out.println("________________________________________________");
            System.out.println("anime with id: " + i);
            System.out.println(animeDetail);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("________________________________________________");
        }

    }
}
