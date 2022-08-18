package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("original")
    @Expose
    public String original;

    @SerializedName("preview")
    @Expose
    public String preview;

    @SerializedName("x96")
    @Expose
    public String x96;

    @SerializedName("x48")
    @Expose
    public String x48;

}