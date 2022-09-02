package com.yauhescha.javashiki.model.domen.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Ratings {

    @SerializedName("anime")
    @Expose
    private List<ScoreItem> anime = new ArrayList<>();

}
