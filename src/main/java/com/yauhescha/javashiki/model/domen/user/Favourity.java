package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Favourity implements Serializable {

    @SerializedName("animes")
    @Expose
    private List<FavourityItem> animes = new ArrayList<>();
    @SerializedName("mangas")
    @Expose
    private List<FavourityItem> mangas = new ArrayList<>();
    @SerializedName("ranobe")
    @Expose
    private List<FavourityItem> ranobe = new ArrayList<>();
    @SerializedName("characters")
    @Expose
    private List<FavourityItem> characters = new ArrayList<>();
    @SerializedName("people")
    @Expose
    private List<FavourityItem> people = new ArrayList<>();
    @SerializedName("mangakas")
    @Expose
    private List<FavourityItem> mangakas = new ArrayList<>();
    @SerializedName("seyu")
    @Expose
    private List<FavourityItem> seyu = new ArrayList<>();
    @SerializedName("producers")
    @Expose
    private List<FavourityItem> producers = new ArrayList<>();

}
