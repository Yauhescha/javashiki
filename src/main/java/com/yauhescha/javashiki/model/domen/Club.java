package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Club implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("logo")
    @Expose
    private Logo logo;

    @SerializedName("is_censored")
    @Expose
    private Boolean isCensored;

    @SerializedName("join_policy")
    @Expose
    private String joinPolicy;

    @SerializedName("comment_policy")
    @Expose
    private String commentPolicy;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;

    @SerializedName("mangas")
    @Expose
    private java.util.List<Manga> mangas;

    @SerializedName("characters")
    @Expose
    private java.util.List<Character> characters;

    @SerializedName("thread_id")
    @Expose
    private Long threadId;

    @SerializedName("topic_id")
    @Expose
    private Long topicId;

    @SerializedName("user_role")
    @Expose
    private String userRole;

    @SerializedName("style_id")
    @Expose
    private Long styleId;

    @SerializedName("members")
    @Expose
    private java.util.List<User> members;

    @SerializedName("animes")
    @Expose
    private java.util.List<Anime> animes;

    @SerializedName("images")
    @Expose
    private java.util.List<ClubImage> images;

}
