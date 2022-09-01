package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.ExternalLink;
import com.yauhescha.javashiki.model.domen.Franchise;
import com.yauhescha.javashiki.model.domen.Manga;
import com.yauhescha.javashiki.model.domen.MangaFull;
import com.yauhescha.javashiki.model.domen.Related;
import com.yauhescha.javashiki.model.domen.Roles;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.reques.MangaSearchParameters;
import com.yauhescha.javashiki.model.reques.MangaTopicParameters;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.yauhescha.javashiki.request.RequestType.GET;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_EXTERNAL_LINKS;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_FRANCHISE;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_GET;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_GET_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_RELATED;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_ROLES;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_SIMILAR;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_MANGAS_TOPICS;

//TODO
@RequiredArgsConstructor
public class MangaApi {
    private final AuthShikimori auth;

    public List<Manga> searchManga(MangaSearchParameters parameters) {
        Manga[] array = new ApiRequest<>(auth, Manga[].class)
                .execute(GET, METHOD_MANGAS_GET, parameters.getSearchParameters());
        if (array == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(array);
    }

    public Optional<MangaFull> getMangaDetail(int mangaId) {
        MangaFull entity = new ApiRequest<>(auth, MangaFull.class)
                .execute(GET, String.format(METHOD_MANGAS_GET_ID, mangaId));
        return Optional.of(entity);
    }

    public List<Roles> getRoles(int mangaId) {
        Roles[] roles = new ApiRequest<>(auth, Roles[].class)
                .execute(GET, String.format(METHOD_MANGAS_ROLES, mangaId));
        if (roles == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(roles);
    }

    public List<Manga> getSimilar(int mangaId) {
        Manga[] array = new ApiRequest<>(auth, Manga[].class)
                .execute(GET, String.format(METHOD_MANGAS_SIMILAR, mangaId));
        if (array == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(array);
    }

    public List<Related> getRelated(int mangaId) {
        Related[] relatedList = new ApiRequest<>(auth, Related[].class)
                .execute(GET, String.format(METHOD_MANGAS_RELATED, mangaId));
        if (relatedList == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(relatedList);
    }

    public Optional<Franchise> getFranchise(int mangaId) {
        Franchise franchise = new ApiRequest<>(auth, Franchise.class)
                .execute(GET, String.format(METHOD_MANGAS_FRANCHISE, mangaId));
        return Optional.of(franchise);
    }

    public List<ExternalLink> getExternalLinks(int mangaId) {
        ExternalLink[] links = new ApiRequest<>(auth, ExternalLink[].class)
                .execute(GET, String.format(METHOD_MANGAS_EXTERNAL_LINKS, mangaId));
        if (links == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(links);
    }

    public List<Topic> getTopics(int animeId) {
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, String.format(METHOD_MANGAS_TOPICS, animeId));
        if (topics == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(topics);
    }

    public List<Topic> getTopics(int animeId, MangaTopicParameters parameters) {
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, String.format(METHOD_MANGAS_TOPICS, animeId), parameters.getSearchParameters());
        if (topics == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(topics);
    }
}
