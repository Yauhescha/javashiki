package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AnimeForCharacter extends Anime implements Serializable {

    @SerializedName("roles")
    @Expose
    private List<String> roles = new ArrayList<>();

    @SerializedName("role")
    @Expose
    private String role;
}