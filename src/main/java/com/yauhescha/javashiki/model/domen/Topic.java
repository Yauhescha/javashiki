package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Topic implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("topic_title")
    @Expose
    private String topicTitle;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("html_body")
    @Expose
    private String htmlBody;

    @SerializedName("html_footer")
    @Expose
    private String htmlFooter;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("comments_count")
    @Expose
    private Long commentsCount;

    @SerializedName("forum")
    @Expose
    private Forum forum;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("linked_id")
    @Expose
    private Long linkedId;

    @SerializedName("linked_type")
    @Expose
    private String linkedType;

    @SerializedName("linked")
    @Expose
    private Anime linked;

    @SerializedName("viewed")
    @Expose
    private Boolean viewed;

    @SerializedName("last_comment_viewed")
    @Expose
    private Boolean lastCommentViewed;

    @SerializedName("event")
    @Expose
    private String event;

    //TODO
//    @SerializedName("episode")
//    @Expose
//    private Object episode;

}
