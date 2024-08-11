package com.yauhescha.javashiki.model.domen.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Ratings implements Serializable {

    @SerializedName("anime")
    @Expose
    private List<ScoreItem> anime = new ArrayList<>();

}