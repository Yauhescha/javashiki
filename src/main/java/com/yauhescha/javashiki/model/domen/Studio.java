package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Studio {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("filtered_name")
    @Expose
    private String filteredName;

    @SerializedName("real")
    @Expose
    private Boolean real;

    @SerializedName("image")
    @Expose
    private String image;

}
