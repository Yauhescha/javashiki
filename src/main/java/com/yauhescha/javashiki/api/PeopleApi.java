package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.People;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_PEOPLES_GET_ID;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class PeopleApi {
    private final AuthShikimori auth;

    public Optional<People> findById(int peopleId) {
        People entity = new ApiRequest<>(auth, People.class)
                .execute(GET, String.format(METHOD_PEOPLES_GET_ID, peopleId));
        return Optional.of(entity);
    }
}
