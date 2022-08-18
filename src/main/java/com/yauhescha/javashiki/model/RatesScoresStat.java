package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RatesScoresStat {

    @SerializedName("name")
    @Expose
    private Long name;

    @SerializedName("value")
    @Expose
    private Long value;

}