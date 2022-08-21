package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.service.AnimeApiService;

import java.util.List;

//TODO remove comment
//String defaultLogin = "fpo81406";
public class ainer {
    public static void main(String[] args) {
        int animeId = 263;
        AuthShikimori authShikimori = new AuthShikimori();
        AnimeApiService animeApi = authShikimori.getAnimeApi();

        List<Anime> similar = animeApi.getSimilar(animeId);

        System.out.println(similar);
        System.out.println("________________________________________________");
        System.out.println();

    }
}
