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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class RanobeApi {
    private final AuthShikimori auth;

    public List<Manga> getRanobe(MangaSearchParameters parameters) {
        Manga[] array = new ApiRequest<>(auth, Manga[].class)
                .execute(GET, METHOD_RANOBE_GET, parameters.getSearchParameters());
        if (array == null) {
            return List.of();
        }
        return Arrays.asList(array);
    }

    public Optional<MangaFull> getRanobeDetail(int ranobeId) {
        MangaFull entity = new ApiRequest<>(auth, MangaFull.class)
                .execute(GET, String.format(METHOD_RANOBE_GET_ID, ranobeId));
        return Optional.ofNullable(entity);
    }

    public List<Roles> getRoles(int ranobeId) {
        Roles[] roles = new ApiRequest<>(auth, Roles[].class)
                .execute(GET, String.format(METHOD_RANOBE_ROLES, ranobeId));
        if (roles == null) {
            return List.of();
        }
        return Arrays.asList(roles);
    }

    public List<Manga> getSimilar(int ranobeId) {
        Manga[] array = new ApiRequest<>(auth, Manga[].class)
                .execute(GET, String.format(METHOD_RANOBE_SIMILAR, ranobeId));
        if (array == null) {
            return List.of();
        }
        return Arrays.asList(array);
    }

    public List<Related> getRelated(int ranobeId) {
        Related[] relatedList = new ApiRequest<>(auth, Related[].class)
                .execute(GET, String.format(METHOD_RANOBE_RELATED, ranobeId));
        if (relatedList == null) {
            return List.of();
        }
        return Arrays.asList(relatedList);
    }

    public Optional<Franchise> getFranchise(int ranobeId) {
        Franchise franchise = new ApiRequest<>(auth, Franchise.class)
                .execute(GET, String.format(METHOD_RANOBE_FRANCHISE, ranobeId));
        return Optional.ofNullable(franchise);
    }

    public List<ExternalLink> getExternalLinks(int ranobeId) {
        ExternalLink[] links = new ApiRequest<>(auth, ExternalLink[].class)
                .execute(GET, String.format(METHOD_RANOBE_EXTERNAL_LINKS, ranobeId));
        if (links == null) {
            return List.of();
        }
        return Arrays.asList(links);
    }

    public List<Topic> getTopics(int ranobeId) {
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, String.format(METHOD_RANOBE_TOPICS, ranobeId));
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }

    public List<Topic> getTopics(int ranobeId, MangaTopicParameters parameters) {
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, String.format(METHOD_RANOBE_TOPICS, ranobeId), parameters.getSearchParameters());
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }
}
