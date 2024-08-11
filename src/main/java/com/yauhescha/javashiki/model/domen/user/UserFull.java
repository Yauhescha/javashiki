package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yauhescha.javashiki.model.domen.User;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserFull extends User implements Serializable {

    //TODO
//    @SerializedName("name")
//    @Expose
//    private Object name;

    @SerializedName("sex")
    @Expose
    private String sex;

    //TODO
//    @SerializedName("full_years")
//    @Expose
//    private Object fullYears;

    @SerializedName("last_online")
    @Expose
    private String lastOnline;

    @SerializedName("website")
    @Expose
    private String website;

    //TODO
//    @SerializedName("location")
//    @Expose
//    private Object location;

    @SerializedName("banned")
    @Expose
    private Boolean banned;

    @SerializedName("about")
    @Expose
    private String about;

    @SerializedName("about_html")
    @Expose
    private String aboutHtml;

    @SerializedName("common_info")
    @Expose
    private List<String> commonInfo = new ArrayList<>();

    @SerializedName("show_comments")
    @Expose
    private Boolean showComments;

    @SerializedName("in_friends")
    @Expose
    private Boolean inFriends;

    @SerializedName("is_ignored")
    @Expose
    private Boolean isIgnored;

    @SerializedName("stats")
    @Expose
    private Stats stats;

    @SerializedName("style_id")
    @Expose
    private Long styleId;

}
