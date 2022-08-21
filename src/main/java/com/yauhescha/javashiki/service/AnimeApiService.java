package com.yauhescha.javashiki.service;

import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.util.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_GET_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_SCREENSHOTS;

//TODO
@RequiredArgsConstructor
public class AnimeApiService {
    private final AuthShikimori auth;

    public Optional<AnimeFull> getAnimeDetail(int animeId) {
        String url = String.format(METHOD_ANIMES_GET_ID, animeId);
        AnimeFull anime = new ApiRequest<>(auth, AnimeFull.class).execute(url);
        if (anime == null) {
            return Optional.empty();
        }
        anime.setScreenshots(getScreenshots(animeId));
        return Optional.of(anime);
    }

    public List<Screenshot> getScreenshots(int animeId) {
        String url = String.format(METHOD_ANIMES_SCREENSHOTS, animeId);
        Screenshot[] screenshots = new ApiRequest<>(auth, Screenshot[].class).execute(url);
        if (screenshots == null) {
            throw new RuntimeException("Screenshots not found for anime with id: " + animeId);
        }
        return Arrays.asList(screenshots);
    }

//    public List<Anime> getAnimes() {
//        return null;
//    }
//
//    public List<Roles> getRoles(int animeId) {
//        return null;
//    }
//
//    public List<Anime> getSimilar(int animeId) {
//        return null;
//    }
//
//    public List<Related> getRelated(int animeId) {
//        return null;
//    }
//
//    public Optional<Franchise> getFranchise(int animeId) {
//        return Optional.empty();
//    }
//
//    public List<ExternalLink> getExternalLinks(int animeId) {
//        return null;
//    }
}
