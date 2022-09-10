package com.yauhescha.javashiki.model.domen.user;

import lombok.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Data
public class FavourityItem {

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
    private String image;
}

