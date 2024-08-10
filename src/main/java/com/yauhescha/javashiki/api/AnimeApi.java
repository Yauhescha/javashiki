package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.AnimeFull;
import com.yauhescha.javashiki.model.domen.ExternalLink;
import com.yauhescha.javashiki.model.domen.Franchise;
import com.yauhescha.javashiki.model.domen.Related;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Screenshot;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.reques.AnimeSearchParameters;
import com.yauhescha.javashiki.model.reques.AnimeTopicParameters;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.NonNull;
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
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_ANIMES_TOPICS;
import static com.yauhescha.javashiki.request.RequestType.GET;

//TODO
@RequiredArgsConstructor
public class AnimeApi {
    private final AuthShikimori auth;

    public List<Anime> getAnimes(@NonNull AnimeSearchParameters parameters) {
        Anime[] animes = new ApiRequest<>(auth, Anime[].class)
            .execute(GET, METHOD_ANIMES_GET, parameters.getSearchParameters());
        if (animes == null) {
            return List.of();
        }
        return Arrays.asList(animes);
    }

    public Optional<AnimeFull> getAnimeDetail(@NonNull int animeId, boolean withAllScreenshots) {
        AnimeFull anime = new ApiRequest<>(auth, AnimeFull.class)
                .execute(GET, String.format(METHOD_ANIMES_GET_ID, animeId));
        if (anime == null) {
            return Optional.empty();
        }
        if (withAllScreenshots) {
            anime.setScreenshots(getScreenshots(animeId));
        }
        return Optional.of(anime);
    }

    public List<Screenshot> getScreenshots(@NonNull int animeId) {
        Screenshot[] screenshots = new ApiRequest<>(auth, Screenshot[].class)
                .execute(GET, String.format(METHOD_ANIMES_SCREENSHOTS, animeId));
        if (screenshots == null) {
            return List.of();
        }
        return Arrays.asList(screenshots);
    }

    public List<Roles> getRoles(@NonNull int animeId, boolean onlyCharacters) {
        Roles[] roles = new ApiRequest<>(auth, Roles[].class)
                .execute(GET, String.format(METHOD_ANIMES_ROLES, animeId));
        if (roles == null) {
            return List.of();
        }
        if (!onlyCharacters) {
            return Arrays.asList(roles);
        }
        return Stream.of(roles)
                .filter(role -> !role.getRoles().isEmpty())
                .filter(role -> role.getRoles().contains("Main") || role.getRoles().contains("Supporting"))
                .collect(Collectors.toList());
    }

    public List<Anime> getSimilar(@NonNull int animeId) {
        Anime[] animes = new ApiRequest<>(auth, Anime[].class)
                .execute(GET, String.format(METHOD_ANIMES_SIMILAR, animeId));
        if (animes == null) {
            return List.of();
        }
        return Arrays.asList(animes);
    }

    public List<Related> getRelated(@NonNull int animeId) {
        Related[] relatedList = new ApiRequest<>(auth, Related[].class)
                .execute(GET, String.format(METHOD_ANIMES_RELATED, animeId));
        if (relatedList == null) {
            return List.of();
        }
        return Arrays.asList(relatedList);
    }

    public List<ExternalLink> getExternalLinks(@NonNull int animeId) {
        ExternalLink[] links = new ApiRequest<>(auth, ExternalLink[].class)
                .execute(GET, String.format(METHOD_ANIMES_EXTERNAL_LINKS, animeId));
        if (links == null) {
            return List.of();
        }
        return Arrays.asList(links);
    }

    public Optional<Franchise> getFranchise(int animeId) {
        Franchise franchise = new ApiRequest<>(auth, Franchise.class)
                .execute(GET, String.format(METHOD_ANIMES_FRANCHISE, animeId));
        return Optional.of(franchise);
    }

    public List<Topic> getTopics(@NonNull int animeId) {
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, String.format(METHOD_ANIMES_TOPICS, animeId));
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }

    public List<Topic> getTopics(@NonNull int animeId, AnimeTopicParameters parameters) {
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, String.format(METHOD_ANIMES_TOPICS, animeId), parameters.getSearchParameters());
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }
}
