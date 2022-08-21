package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.ExternalLink;
import com.yauhescha.javashiki.model.domen.Franchise;
import com.yauhescha.javashiki.model.domen.Related;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.model.reques.AnimeSearchParameters;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_EXTERNAL_LINKS;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_FRANCHISE;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_GET;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_GET_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_RELATED;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_ROLES;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_SCREENSHOTS;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_SIMILAR;

//TODO
@RequiredArgsConstructor
public class AnimeApi {
    private final AuthShikimori auth;

    public Optional<AnimeFull> getAnimeDetail(int animeId, boolean withAllScreenshots) {
        AnimeFull anime = new ApiRequest<>(auth, AnimeFull.class)
                .execute(String.format(METHOD_ANIMES_GET_ID, animeId));
        if (anime == null) {
            return Optional.empty();
        }
        if (withAllScreenshots) {
            anime.setScreenshots(getScreenshots(animeId));
        }
        return Optional.of(anime);
    }

    public List<Screenshot> getScreenshots(int animeId) {
        Screenshot[] screenshots = new ApiRequest<>(auth, Screenshot[].class)
                .execute(String.format(METHOD_ANIMES_SCREENSHOTS, animeId));
        if (screenshots == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(screenshots);
    }

    public List<Roles> getRoles(int animeId, boolean onlyCharacters) {
        Roles[] roles = new ApiRequest<>(auth, Roles[].class)
                .execute(String.format(METHOD_ANIMES_ROLES, animeId));
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

    public List<Anime> getSimilar(int animeId) {
        Anime[] animes = new ApiRequest<>(auth, Anime[].class)
                .execute(String.format(METHOD_ANIMES_SIMILAR, animeId));
        return Arrays.asList(animes);
    }

    public List<Related> getRelated(int animeId) {
        Related[] relatedList = new ApiRequest<>(auth, Related[].class)
                .execute(String.format(METHOD_ANIMES_RELATED, animeId));
        return Arrays.asList(relatedList);
    }

    public List<ExternalLink> getExternalLinks(int animeId) {
        ExternalLink[] links = new ApiRequest<>(auth, ExternalLink[].class)
                .execute(String.format(METHOD_ANIMES_EXTERNAL_LINKS, animeId));
        return Arrays.asList(links);
    }

    public Optional<Franchise> getFranchise(int animeId) {
        Franchise franchise = new ApiRequest<>(auth, Franchise.class)
                .execute(String.format(METHOD_ANIMES_FRANCHISE, animeId));
        return Optional.of(franchise);
    }

    public List<Anime> getAnimes(AnimeSearchParameters parameters) {
        Anime[] animes = new ApiRequest<>(auth, Anime[].class)
                .execute(METHOD_ANIMES_GET, parameters.getSearchParameters());
        return Arrays.asList(animes);
    }

//    public List<Topic> getTopics() {
//        return null;
//    }
}
