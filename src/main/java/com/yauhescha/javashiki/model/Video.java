package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("id")
    @Expose
    public Long id;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("image_url")
    @Expose
    public String imageUrl;

    @SerializedName("player_url")
    @Expose
    public String playerUrl;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("kind")
    @Expose
    public String kind;

    @SerializedName("hosting")
    @Expose
    public String hosting;

}