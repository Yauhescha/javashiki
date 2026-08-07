package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserRate implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("user_id")
    @Expose
    private Long userId;

    @SerializedName("target_id")
    @Expose
    private Long targetId;

    @SerializedName("target_type")
    @Expose
    private String targetType;

    @SerializedName("score")
    @Expose
    private Integer score;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("rewatches")
    @Expose
    private Integer rewatches;

    @SerializedName("episodes")
    @Expose
    private Integer episodes;

    @SerializedName("volumes")
    @Expose
    private Integer volumes;

    @SerializedName("chapters")
    @Expose
    private Integer chapters;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("text_html")
    @Expose
    private String textHtml;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("anime")
    @Expose
    private Anime anime;

    @SerializedName("manga")
    @Expose
    private Manga manga;

}
