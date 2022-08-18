package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("id")
    @Expose
    public Long id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("russian")
    @Expose
    public String russian;

    @SerializedName("image")
    @Expose
    public Image image;

    @SerializedName("url")
    @Expose
    public String url;

}