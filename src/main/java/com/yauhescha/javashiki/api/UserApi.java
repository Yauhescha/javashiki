package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Ban;
import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.user.Club;
import com.yauhescha.javashiki.model.domen.user.UnreadMessages;
import com.yauhescha.javashiki.model.domen.user.UserFull;
import com.yauhescha.javashiki.model.domen.user.UserInfo;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_BANS;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_CLUBS;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_GET;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_GET_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_INFO;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_UNREAD_MESSAGES;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_WHOAMI;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class UserApi {
    private final AuthShikimori auth;

    public List<User> getUsers() {
        return getUsers(null, null);
    }

    public List<User> getUsers(Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        User[] array = new ApiRequest<>(auth, User[].class)
                .execute(GET, METHOD_USERS_GET, params);
        if (array == null) {
            //TODO made all return empty list.of
            return new ArrayList<>();
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
            //TODO made all return empty list.of
            return new ArrayList<>();
        }
        return List.of(array);
    }

    public List<Club> getClubs(int userId) {
        Club[] array = new ApiRequest<>(auth, Club[].class)
                .execute(GET, String.format(METHOD_USERS_CLUBS, userId));
        if (array == null) {
            //TODO made all return empty list.of
            return new ArrayList<>();
        }
        return List.of(array);
    }
}
