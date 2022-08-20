package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Related {

    @SerializedName("relation")
    @Expose
    private String relation;
    
    @SerializedName("relation_russian")
    @Expose
    private String relationRussian;
    
    @SerializedName("anime")
    @Expose
    private AnimeShort animeShort;
    
    @SerializedName("manga")
    @Expose
    private Manga manga;

}