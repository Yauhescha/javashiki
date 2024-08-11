package com.yauhescha.javashiki.model.domen.consant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AnimeMangaConstant implements Serializable {

    @SerializedName("kind")
    @Expose
    private List<String> kind = new ArrayList<>();

    @SerializedName("status")
    @Expose
    private List<String> status = new ArrayList<>();

}
