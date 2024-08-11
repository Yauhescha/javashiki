package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Achievement implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("neko_id")
    @Expose
    private String nekoId;

    @SerializedName("level")
    @Expose
    private Long level;

    @SerializedName("progress")
    @Expose
    private Long progress;

    @SerializedName("user_id")
    @Expose
    private Long userId;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

}
