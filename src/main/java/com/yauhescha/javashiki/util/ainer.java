package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.AnimeApi;
import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.reques.AnimeSearchParameters;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;

//TODO remove comment
//String defaultLogin = "fpo81406";
public class ainer {
    public static void main(String[] args) {
        AuthShikimori authShikimori = new AuthShikimori();

        AnimeSearchParameters parameters = AnimeSearchParameters
                .builder()
                .limit(5)
                .search("naruto")
                .build();

        AnimeApi animeApi = authShikimori.getAnimeApi();

        List<Anime> animes = animeApi.getAnimes(parameters);

        System.out.println("________________________________________________");
        System.out.println(animes);
        System.out.println("________________________________________________");
        System.out.println();

    }
}
