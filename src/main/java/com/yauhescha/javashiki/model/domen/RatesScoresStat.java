package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class RatesScoresStat implements Serializable {

    @SerializedName("name")
    @Expose
    private Long name;

    @SerializedName("value")
    @Expose
    private Long value;

}