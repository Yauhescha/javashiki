package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Ban implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("user_id")
    @Expose
    private Long userId;

    @SerializedName("comment")
    @Expose
    private Comment comment;

    @SerializedName("moderator_id")
    @Expose
    private Long moderatorId;

    @SerializedName("reason")
    @Expose
    private String reason;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("duration_minutes")
    @Expose
    private Long durationMinutes;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("moderator")
    @Expose
    private User moderator;
}
