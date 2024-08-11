package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yauhescha.javashiki.model.domen.Image;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {

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

    //TODO
//    @SerializedName("name")
//    @Expose
//    private Object name;

    @SerializedName("sex")
    @Expose
    private String sex;

    @SerializedName("website")
    @Expose
    private String website;

    //TODO
//    @SerializedName("birth_on")
//    @Expose
//    private Object birthOn;

    @SerializedName("full_years")
    @Expose
    private Long fullYears;

    @SerializedName("locale")
    @Expose
    private String locale;
}
