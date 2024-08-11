package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Image implements Serializable {

    @SerializedName("original")
    @Expose
    private String original;

    @SerializedName("preview")
    @Expose
    private String preview;

    @SerializedName("x96")
    @Expose
    private String x96;

    @SerializedName("x48")
    @Expose
    private String x48;

}