package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClubImage implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("original_url")
    @Expose
    private String originalUrl;

    @SerializedName("main_url")
    @Expose
    private String mainUrl;

    @SerializedName("preview_url")
    @Expose
    private String previewUrl;

    @SerializedName("can_destroy")
    @Expose
    private Boolean canDestroy;

    @SerializedName("user_id")
    @Expose
    private Long userId;

}
