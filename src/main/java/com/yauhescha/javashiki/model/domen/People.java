package com.yauhescha.javashiki.model.domen;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class People {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("russian")
    @Expose
    private String russian;

    @SerializedName("image")
    @Expose
    private Image image;

    @SerializedName("url")
    @Expose
    private String url;

}
