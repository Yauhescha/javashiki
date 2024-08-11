package com.yauhescha.javashiki.model.domen.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Club implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("logo")
    @Expose
    private Logo logo;

    @SerializedName("is_censored")
    @Expose
    private Boolean isCensored;

    @SerializedName("join_policy")
    @Expose
    private String joinPolicy;

    @SerializedName("comment_policy")
    @Expose
    private String commentPolicy;

}
