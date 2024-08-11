package com.yauhescha.javashiki.model.domen.consant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserRateConstant {

    @SerializedName("status")
    @Expose
    private List<String> status = new ArrayList<>();

}
