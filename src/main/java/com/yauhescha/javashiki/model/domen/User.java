package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    public Long id;

    @SerializedName("nickname")
    @Expose
    public String nickname;

    @SerializedName("avatar")
    @Expose
    public String avatar;

    @SerializedName("image")
    @Expose
    public Image image;

    @SerializedName("last_online_at")
    @Expose
    public String lastOnlineAt;

    @SerializedName("url")
    @Expose
    public String url;

}
