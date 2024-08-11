package com.yauhescha.javashiki.model.domen.consant;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class SmileConstant implements Serializable {

    @SerializedName("bbcode")
    @Expose
    private String bbcode;

    @SerializedName("path")
    @Expose
    private String path;

}
