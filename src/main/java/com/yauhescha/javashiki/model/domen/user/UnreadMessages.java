package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class UnreadMessages implements Serializable {

    @SerializedName("messages")
    @Expose
    private Long messages;

    @SerializedName("news")
    @Expose
    private Long news;

    @SerializedName("notifications")
    @Expose
    private Long notifications;

}
