package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.CharacterFull;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CHARACTERS_GET_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CHARACTERS_SEARCH;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class CharacterApi {
    private final AuthShikimori auth;

    public Optional<CharacterFull> findById(int id) {
        CharacterFull entity = new ApiRequest<>(auth, CharacterFull.class)
                .execute(GET, String.format(METHOD_CHARACTERS_GET_ID, id));
        return Optional.of(entity);
    }

    public List<CharacterFull> search(String search) {
        CharacterFull[] array = new ApiRequest<>(auth, CharacterFull[].class)
                .execute(GET, METHOD_CHARACTERS_SEARCH, Map.of("search", search));
        if (array == null) {
            return new ArrayList<>();
        }
        return List.of(array);
    }
}
