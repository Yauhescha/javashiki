package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forum {

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
