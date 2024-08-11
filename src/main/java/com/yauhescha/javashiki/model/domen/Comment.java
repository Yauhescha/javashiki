package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Comment implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("commentable_id")
    @Expose
    private Long commentableId;

    @SerializedName("commentable_type")
    @Expose
    private String commentableType;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("user_id")
    @Expose
    private Long userId;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("is_offtopic")
    @Expose
    private Boolean isOfftopic;
}
