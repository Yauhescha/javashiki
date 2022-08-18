package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatesScoresStat {

    @SerializedName("name")
    @Expose
    public Long name;

    @SerializedName("value")
    @Expose
    public Long value;

}