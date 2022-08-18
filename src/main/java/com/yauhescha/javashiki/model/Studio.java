package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//TODO: update all commented field
public class Studio {

    @SerializedName("id")
    @Expose
    public Long id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("filtered_name")
    @Expose
    public String filteredName;

    @SerializedName("real")
    @Expose
    public Boolean real;

//    @SerializedName("image")
//    @Expose
//    public Object image;

}
