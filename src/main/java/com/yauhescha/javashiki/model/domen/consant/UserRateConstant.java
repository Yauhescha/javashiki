package com.yauhescha.javashiki.model.domen.consant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UserRateConstant implements Serializable {

    @SerializedName("status")
    @Expose
    private List<String> status = new ArrayList<>();

}
