package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("nickname")
    @Expose
    private String nickname;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("image")
    @Expose
    private Image image;

    @SerializedName("last_online_at")
    @Expose
    private String lastOnlineAt;

    @SerializedName("url")
    @Expose
    private String url;

}
