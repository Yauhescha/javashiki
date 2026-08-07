package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Anime;
import com.yauhescha.javashiki.model.domen.Character;
import com.yauhescha.javashiki.model.domen.Club;
import com.yauhescha.javashiki.model.domen.ClubImage;
import com.yauhescha.javashiki.model.domen.Manga;
import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class ClubApi {
    private final AuthShikimori auth;

    public List<Club> getClubs(Integer page, Integer limit, String search) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        if (search != null) {
            params.put("search", search);
        }
        Club[] clubs = new ApiRequest<>(auth, Club[].class)
                .execute(GET, METHOD_CLUBS_GET, params);
        if (clubs == null) {
            return List.of();
        }
        return Arrays.asList(clubs);
    }

    public Optional<Club> getClub(int clubId) {
        Club club = new ApiRequest<>(auth, Club.class)
                .execute(GET, String.format(METHOD_CLUBS_GET_ID, clubId));
        return Optional.ofNullable(club);
    }

    public Club updateClub(int clubId, Map<String, Object> clubParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("club", clubParams);
        return new ApiRequest<>(auth, Club.class)
                .execute(PATCH, String.format(METHOD_CLUBS_GET_ID, clubId), params);
    }

    public List<Anime> getClubAnimes(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Anime[] animes = new ApiRequest<>(auth, Anime[].class)
                .execute(GET, String.format(METHOD_CLUBS_ANIMES, clubId), params);
        if (animes == null) {
            return List.of();
        }
        return Arrays.asList(animes);
    }

    public List<Manga> getClubMangas(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Manga[] mangas = new ApiRequest<>(auth, Manga[].class)
                .execute(GET, String.format(METHOD_CLUBS_MANGAS, clubId), params);
        if (mangas == null) {
            return List.of();
        }
        return Arrays.asList(mangas);
    }

    public List<Manga> getClubRanobe(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Manga[] ranobe = new ApiRequest<>(auth, Manga[].class)
                .execute(GET, String.format(METHOD_CLUBS_RANOBE, clubId), params);
        if (ranobe == null) {
            return List.of();
        }
        return Arrays.asList(ranobe);
    }

    public List<Character> getClubCharacters(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Character[] characters = new ApiRequest<>(auth, Character[].class)
                .execute(GET, String.format(METHOD_CLUBS_CHARACTERS, clubId), params);
        if (characters == null) {
            return List.of();
        }
        return Arrays.asList(characters);
    }

    public List<Topic> getClubCollections(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, String.format(METHOD_CLUBS_COLLECTIONS, clubId), params);
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }

    public List<Club> getClubClubs(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Club[] clubs = new ApiRequest<>(auth, Club[].class)
                .execute(GET, String.format(METHOD_CLUBS_CLUBS, clubId), params);
        if (clubs == null) {
            return List.of();
        }
        return Arrays.asList(clubs);
    }

    public List<User> getClubMembers(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        User[] members = new ApiRequest<>(auth, User[].class)
                .execute(GET, String.format(METHOD_CLUBS_MEMBERS, clubId), params);
        if (members == null) {
            return List.of();
        }
        return Arrays.asList(members);
    }

    public List<ClubImage> getClubImages(int clubId, Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        ClubImage[] images = new ApiRequest<>(auth, ClubImage[].class)
                .execute(GET, String.format(METHOD_CLUBS_IMAGES, clubId), params);
        if (images == null) {
            return List.of();
        }
        return Arrays.asList(images);
    }

    public void joinClub(int clubId) {
        new ApiRequest<>(auth, Object.class)
                .execute(POST, String.format(METHOD_CLUBS_JOIN, clubId));
    }

    public void leaveClub(int clubId) {
        new ApiRequest<>(auth, Object.class)
                .execute(POST, String.format(METHOD_CLUBS_LEAVE, clubId));
    }
}
