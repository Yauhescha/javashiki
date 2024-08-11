package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video implements Serializable {

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