package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Image {

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