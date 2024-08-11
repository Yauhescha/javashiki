package com.yauhescha.javashiki.model.domen.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageUser implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("nickname")
    @Expose
    private String nickname;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("image")
    @Expose
    private MessageImage image;

    @SerializedName("last_online_at")
    @Expose
    private String lastOnlineAt;

    @SerializedName("url")
    @Expose
    private String url;
}
