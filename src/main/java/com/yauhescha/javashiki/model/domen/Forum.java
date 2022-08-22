package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forum {

    @SerializedName("id")
    @Expose
    public Long id;

    @SerializedName("position")
    @Expose
    public Long position;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("permalink")
    @Expose
    public String permalink;

    @SerializedName("url")
    @Expose
    public String url;

}
