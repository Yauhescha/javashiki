package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PeopleRole {

    @SerializedName("characters")
    @Expose
    private List<Character> characters = new ArrayList<>();

    @SerializedName("animes")
    @Expose
    private List<Anime> animes = new ArrayList<>();

}
