package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AnimeShort {

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

    @SerializedName("kind")
    @Expose
    public String kind;

    @SerializedName("score")
    @Expose
    public String score;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("episodes")
    @Expose
    public Long episodes;

    @SerializedName("episodes_aired")
    @Expose
    public Long episodesAired;

    @SerializedName("aired_on")
    @Expose
    public String airedOn;

    @SerializedName("released_on")
    @Expose
    public String releasedOn;

}