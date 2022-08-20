package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Video {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("player_url")
    @Expose
    private String playerUrl;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("hosting")
    @Expose
    private String hosting;

}