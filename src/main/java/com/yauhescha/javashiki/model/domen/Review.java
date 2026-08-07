package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Review implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("user_id")
    @Expose
    private Long userId;

    @SerializedName("anime_id")
    @Expose
    private Long animeId;

    @SerializedName("manga_id")
    @Expose
    private Long mangaId;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("opinion")
    @Expose
    private String opinion;

    @SerializedName("is_written_before_release")
    @Expose
    private Boolean isWrittenBeforeRelease;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("comments_count")
    @Expose
    private Long commentsCount;

    @SerializedName("cached_votes_up")
    @Expose
    private Long cachedVotesUp;

    @SerializedName("cached_votes_down")
    @Expose
    private Long cachedVotesDown;

    @SerializedName("changed_at")
    @Expose
    private String changedAt;

}
