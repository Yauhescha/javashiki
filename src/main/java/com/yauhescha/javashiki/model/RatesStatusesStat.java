package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatesStatusesStat {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("value")
    @Expose
    public Long value;

}