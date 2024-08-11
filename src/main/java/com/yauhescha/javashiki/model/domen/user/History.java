package com.yauhescha.javashiki.model.domen.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class History implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("target")
    @Expose
    private Target target;

}
