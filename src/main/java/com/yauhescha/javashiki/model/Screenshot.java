package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Screenshot {

    @SerializedName("original")
    @Expose
    public String original;

    @SerializedName("preview")
    @Expose
    public String preview;

}