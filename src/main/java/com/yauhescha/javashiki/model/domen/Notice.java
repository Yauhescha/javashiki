package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Notice implements Serializable {

    @SerializedName("notice")
    @Expose
    private String notice;

}
