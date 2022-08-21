package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.service.AnimeApiService;

import java.util.Optional;

//TODO remove comment
//String defaultLogin = "fpo81406";
public class ainer {
    public static void main(String[] args) {
        AuthShikimori authShikimori = new AuthShikimori();
        AnimeApiService animeApi = authShikimori.getAnimeApi();
        for (int i = 1; i < 10; i++) {
            Optional<AnimeFull> maybeAnime = animeApi.getAnimeDetail(i);
            if(maybeAnime.isPresent()) {
                AnimeFull anime = maybeAnime.get();
                System.out.println("________________________________________________");
                System.out.println("anime with id: " + i);
                System.out.println(anime);
                System.out.println("________________________________________________");
                System.out.println();
                System.out.println();
            }
        }

    }
}
