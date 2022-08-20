package com.yauhescha.javashiki.service;

import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.ExternalLink;
import com.yauhescha.javashiki.model.domen.Franchise;
import com.yauhescha.javashiki.model.domen.Related;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.util.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_GET_ID;

//TODO
@RequiredArgsConstructor
public class AnimeApiService {
    private final AuthShikimori auth;

    public AnimeFull getAnimeDetail(int animeId) {
        String url = String.format(METHOD_ANIMES_GET_ID, animeId);
        return new ApiRequest<>(auth, AnimeFull.class)
                .execute(url, null);
    }

    public List<Anime> getAnimes() {
        return null;
    }

    public List<Roles> getRoles(Long animeId) {
        return null;
    }

    public List<Anime> getSimilar(Long animeId) {
        return null;
    }

    public List<Related> getRelated(Long animeId) {
        return null;
    }

    public List<Screenshot> getScreenshots(Long animeId) {
        return null;
    }

    public Optional<Franchise> getFranchise(Long animeId) {
        return Optional.empty();
    }

    public List<ExternalLink> getExternalLinks(Long animeId) {
        return null;
    }
}
