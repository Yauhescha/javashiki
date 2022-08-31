package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Work {

    @SerializedName("anime")
    @Expose
    private Anime anime;

    @SerializedName("manga")
    @Expose
    private Manga manga;

    @SerializedName("role")
    @Expose
    private String role;

}
