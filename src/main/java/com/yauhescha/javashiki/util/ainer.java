package com.yauhescha.javashiki.util;

import com.yauhescha.javashiki.api.ConstantApi;
import com.yauhescha.javashiki.model.domen.consant.SmileConstant;
import com.yauhescha.javashiki.request.AuthShikimori;

import java.util.List;

public class ainer {
    public static void main(String[] args) {
//        new AuthShikimori().
        final ConstantApi constantApi = new AuthShikimori().getConstantApi();

        final List<SmileConstant> smileConstant = constantApi.getSmileConstant();

//constant
//        System.out.println(Arrays.toString(list.toArray()));
        System.out.println();

    }
}
