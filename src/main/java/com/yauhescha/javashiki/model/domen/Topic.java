package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topic {

    @SerializedName("id")
    @Expose
    public Long id;

    @SerializedName("topic_title")
    @Expose
    public String topicTitle;

    @SerializedName("body")
    @Expose
    public String body;

    @SerializedName("html_body")
    @Expose
    public String htmlBody;

    @SerializedName("html_footer")
    @Expose
    public String htmlFooter;

    @SerializedName("created_at")
    @Expose
    public String createdAt;

    @SerializedName("comments_count")
    @Expose
    public Long commentsCount;

    @SerializedName("forum")
    @Expose
    public Forum forum;

    @SerializedName("user")
    @Expose
    public User user;

    @SerializedName("type")
    @Expose
    public String type;

    @SerializedName("linked_id")
    @Expose
    public Long linkedId;

    @SerializedName("linked_type")
    @Expose
    public String linkedType;

    @SerializedName("linked")
    @Expose
    public Anime linked;

    @SerializedName("viewed")
    @Expose
    public Boolean viewed;

    @SerializedName("last_comment_viewed")
    @Expose
    public Boolean lastCommentViewed;

    @SerializedName("event")
    @Expose
    public String event;

    //TODO
//    @SerializedName("episode")
//    @Expose
//    public Object episode;

}
