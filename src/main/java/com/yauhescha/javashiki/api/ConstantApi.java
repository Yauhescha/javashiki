package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.consant.AnimeMangaConstant;
import com.yauhescha.javashiki.model.domen.consant.ClubConstant;
import com.yauhescha.javashiki.model.domen.consant.SmileConstant;
import com.yauhescha.javashiki.model.domen.consant.UserRateConstant;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CONSTANTS_ANIME;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CONSTANTS_CLUB;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CONSTANTS_MANGA;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CONSTANTS_SMILEYS;
import static com.yauhescha.javashiki.constant.ShikiInfo.METHOD_CONSTANTS_USER_RATE;
import static com.yauhescha.javashiki.request.RequestType.GET;

@RequiredArgsConstructor
public class ConstantApi {
    private final AuthShikimori auth;

    public AnimeMangaConstant getAnimeConstant() {
        return new ApiRequest<>(auth, AnimeMangaConstant.class)
                .execute(GET, METHOD_CONSTANTS_ANIME);
    }

    public AnimeMangaConstant getMangaConstant() {
        return new ApiRequest<>(auth, AnimeMangaConstant.class)
                .execute(GET, METHOD_CONSTANTS_MANGA);
    }

    public UserRateConstant getUserRateConstant() {
        return new ApiRequest<>(auth, UserRateConstant.class)
                .execute(GET, METHOD_CONSTANTS_USER_RATE);
    }

    public ClubConstant getClubConstant() {
        return new ApiRequest<>(auth, ClubConstant.class)
                .execute(GET, METHOD_CONSTANTS_CLUB);
    }

    public List<SmileConstant> getSmileConstant() {
        SmileConstant[] list = new ApiRequest<>(auth, SmileConstant[].class)
                .execute(GET, METHOD_CONSTANTS_SMILEYS);
        if (list == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(list);
    }
}
