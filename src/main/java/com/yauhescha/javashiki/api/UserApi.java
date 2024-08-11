package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.AnimeMangaRate;
import com.yauhescha.javashiki.model.domen.Ban;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.message.Message;
import com.yauhescha.javashiki.model.domen.user.Club;
import com.yauhescha.javashiki.model.domen.user.Favourity;
import com.yauhescha.javashiki.model.domen.user.History;
import com.yauhescha.javashiki.model.domen.user.UnreadMessages;
import com.yauhescha.javashiki.model.domen.user.UserFull;
import com.yauhescha.javashiki.model.domen.user.UserInfo;
import com.yauhescha.javashiki.model.reques.AnimeMangaRateParameters;
import com.yauhescha.javashiki.model.reques.UserMessageParameters;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class UserApi {
    private final AuthShikimori auth;

    public List<User> getUsers() {
        return getUsers(null, null, null);
    }

    public List<User> getUsers(Integer page, Integer limit, String search) {
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
        User[] array = new ApiRequest<>(auth, User[].class)
                .execute(GET, METHOD_USERS_GET, params);
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }

    public Optional<UserFull> findUserById(int id) {
        UserFull entity = new ApiRequest<>(auth, UserFull.class)
                .execute(GET, String.format(METHOD_USERS_GET_ID, id));
        return Optional.of(entity);
    }

    public Optional<UserInfo> findUserInfo(int id) {
        UserInfo entity = new ApiRequest<>(auth, UserInfo.class)
                .execute(GET, String.format(METHOD_USERS_INFO, id));
        return Optional.of(entity);
    }

    public Optional<UnreadMessages> findUnreadMessages(int id) {
        UnreadMessages entity = new ApiRequest<>(auth, UnreadMessages.class)
                .execute(GET, String.format(METHOD_USERS_UNREAD_MESSAGES, id));
        return Optional.of(entity);
    }

    public UserInfo whoIAm() {
        return new ApiRequest<>(auth, UserInfo.class)
                .execute(GET, METHOD_USERS_WHOAMI);
    }

    public List<Ban> getBans(int userId) {
        Ban[] array = new ApiRequest<>(auth, Ban[].class)
                .execute(GET, String.format(METHOD_USERS_BANS, userId));
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }

    public List<Club> getClubs(int userId) {
        Club[] array = new ApiRequest<>(auth, Club[].class)
                .execute(GET, String.format(METHOD_USERS_CLUBS, userId));
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }

    public List<History> getHistories(int userId) {
        History[] array = new ApiRequest<>(auth, History[].class)
                .execute(GET, String.format(METHOD_USERS_HISTORY, userId));
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }

    public Favourity getFavourities(int userId) {
        return new ApiRequest<>(auth, Favourity.class)
                .execute(GET, String.format(METHOD_USERS_FAVOURITES, userId));
    }

    public List<User> getFriends(int userId) {
        User[] array = new ApiRequest<>(auth, User[].class)
                .execute(GET, String.format(METHOD_USERS_FRIENDS, userId));
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }

    public List<AnimeMangaRate> getAnimeRates(int userId, AnimeMangaRateParameters parameters) {
        AnimeMangaRate[] array = new ApiRequest<>(auth, AnimeMangaRate[].class)
                .execute(GET, String.format(METHOD_USERS_ANIME_RATES, userId), parameters.getSearchParameters());
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }

    public List<AnimeMangaRate> getMangaRates(int userId, AnimeMangaRateParameters parameters) {
        AnimeMangaRate[] array = new ApiRequest<>(auth, AnimeMangaRate[].class)
                .execute(GET, String.format(METHOD_USERS_MANGA_RATES, userId), parameters.getSearchParameters());
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }

    public List<Message> getMessages(int userId, UserMessageParameters parameters) {
        Message[] array = new ApiRequest<>(auth, Message[].class)
                .execute(GET, String.format(METHOD_USERS_MESSAGES, userId), parameters.getSearchParameters());
        if (array == null) {
            return List.of();
        }
        return List.of(array);
    }
}
