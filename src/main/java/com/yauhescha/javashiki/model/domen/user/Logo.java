package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Logo implements Serializable {

    @SerializedName("original")
    @Expose
    private String original;

    @SerializedName("main")
    @Expose
    private String main;

    @SerializedName("x96")
    @Expose
    private String x96;

    @SerializedName("x73")
    @Expose
    private String x73;

    @SerializedName("x48")
    @Expose
    private String x48;

}
