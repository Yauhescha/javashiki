package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.User;
import com.yauhescha.javashiki.model.domen.user.UserFull;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_GET;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_USERS_GET_ID;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class UserApi {
    private final AuthShikimori auth;

    public List<User> getUsers() {
        return getUsers(null, null);
    }

    public List<User> getUsers(Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if(page!=null){
            params.put("page", page);
        }
        if(limit!=null){
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
        UserFull array = new ApiRequest<>(auth, UserFull.class)
                .execute(GET, String.format(METHOD_USERS_GET_ID, id));
        return Optional.of(array);
    }
}
