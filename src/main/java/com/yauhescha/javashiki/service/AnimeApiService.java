package com.yauhescha.javashiki.service;

import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.util.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_GET_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_ROLES;
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
            return new ArrayList<>();
        }
        return Arrays.asList(screenshots);
    }

    public List<Roles> getRoles(int animeId, boolean onlyCharacters) {
        String url = String.format(METHOD_ANIMES_ROLES, animeId);
        Roles[] roles = new ApiRequest<>(auth, Roles[].class).execute(url);
        if (roles == null) {
            return new ArrayList<>();
        }
        if (!onlyCharacters) {
            return Arrays.asList(roles);
        }
        return Stream.of(roles)
                .filter(role -> !role.getRoles().isEmpty())
                .filter(role -> role.getRoles().contains("Main") || role.getRoles().contains("Supporting"))
                .collect(Collectors.toList());
    }

//    public List<Anime> getAnimes() {
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
