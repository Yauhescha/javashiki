package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RatesStatusesStat {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("value")
    @Expose
    private Long value;

}