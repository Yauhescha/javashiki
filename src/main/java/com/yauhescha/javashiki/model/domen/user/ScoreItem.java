package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ScoreItem {

    @SerializedName("name")
    @Expose
    private String name;
    
    @SerializedName("value")
    @Expose
    private Long value;

}
