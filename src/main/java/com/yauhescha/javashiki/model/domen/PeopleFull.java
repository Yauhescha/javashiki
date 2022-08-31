package com.yauhescha.javashiki.model.domen;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PeopleFull extends People {

    @SerializedName("japanese")
    @Expose
    private String japanese;

    @SerializedName("job_title")
    @Expose
    private String jobTitle;

    @SerializedName("birth_on")
    @Expose
    private String birthOn;

    @SerializedName("deceased_on")
    @Expose
    private String deceasedOn;

    @SerializedName("website")
    @Expose
    private String website;

    //TODO made refactor
    @SerializedName("groupped_roles")
    @Expose
    private List<List<String>> grouppedRoles = new ArrayList<>();

    @SerializedName("roles")
    @Expose
    private List<PeopleRole> roles = new ArrayList<>();

    @SerializedName("works")
    @Expose
    private List<Work> works = new ArrayList<>();

    @SerializedName("topic_id")
    @Expose
    private Long topicId;

    @SerializedName("person_favoured")
    @Expose
    private Boolean personFavoured;

    @SerializedName("producer")
    @Expose
    private Boolean producer;

    @SerializedName("producer_favoured")
    @Expose
    private Boolean producerFavoured;

    @SerializedName("mangaka")
    @Expose
    private Boolean mangaka;

    @SerializedName("mangaka_favoured")
    @Expose
    private Boolean mangakaFavoured;

    @SerializedName("seyu")
    @Expose
    private Boolean seyu;

    @SerializedName("seyu_favoured")
    @Expose
    private Boolean seyuFavoured;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("thread_id")
    @Expose
    private Long threadId;

    @SerializedName("birthday")
    @Expose
    private String birthday;

}
