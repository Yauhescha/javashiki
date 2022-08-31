package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.constant.search.SearchKindType;
import com.yauhescha.javashiki.model.domen.People;
import com.yauhescha.javashiki.model.domen.PeopleFull;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_PEOPLES_GET_ID;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_PEOPLES_SEARCH;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class PeopleApi {
    private final AuthShikimori auth;

    public Optional<PeopleFull> findById(int peopleId) {
        PeopleFull entity = new ApiRequest<>(auth, PeopleFull.class)
                .execute(GET, String.format(METHOD_PEOPLES_GET_ID, peopleId));
        return Optional.of(entity);
    }

    public List<People> search(String search) {
        return search(search, null);
    }

    public List<People> search(String search, SearchKindType searchKindType) {
        Map<String, Object> data = new HashMap<>();
        if (search != null) {
            data.put("search", search);
        }
        if (searchKindType != null) {
            data.put("kind", searchKindType.name());
        }

        People[] array = new ApiRequest<>(auth, People[].class)
                .execute(GET, METHOD_PEOPLES_SEARCH, data);
        if (array == null) {
            return new ArrayList<>();
        }
        return List.of(array);
    }
}
