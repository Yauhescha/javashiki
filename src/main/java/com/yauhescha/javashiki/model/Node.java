package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Node {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("date")
    @Expose
    private Long date;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("year")
    @Expose
    private Long year;

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("weight")
    @Expose
    private Long weight;

}