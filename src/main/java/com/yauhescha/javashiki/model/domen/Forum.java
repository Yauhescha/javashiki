package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Forum implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("position")
    @Expose
    private Long position;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("permalink")
    @Expose
    private String permalink;

    @SerializedName("url")
    @Expose
    private String url;

}
