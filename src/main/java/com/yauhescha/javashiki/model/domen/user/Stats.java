package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Stats implements Serializable {

    @SerializedName("statuses")
    @Expose
    private Statuses statuses;

    @SerializedName("full_statuses")
    @Expose
    private FullStatuses fullStatuses;

    @SerializedName("scores")
    @Expose
    private Scores scores;

    @SerializedName("types")
    @Expose
    private Types types;

    @SerializedName("ratings")
    @Expose
    private Ratings ratings;

    @SerializedName("has_anime?")
    @Expose
    private Boolean hasAnime;

    @SerializedName("has_manga?")
    @Expose
    private Boolean hasManga;

//    //TODO
//    @SerializedName("genres")
//    @Expose
//    private List<Object> genres = new ArrayList<>();
//
//    //TODO
//    @SerializedName("studios")
//    @Expose
//    private List<Object> studios = new ArrayList<>();
//
//    //TODO
//    @SerializedName("publishers")
//    @Expose
//    private List<Object> publishers = new ArrayList<>();

    @SerializedName("activity")
    @Expose
    private List<Activity> activity = new ArrayList<>();

}
