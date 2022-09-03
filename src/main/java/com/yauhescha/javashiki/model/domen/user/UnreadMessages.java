package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UnreadMessages {

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
