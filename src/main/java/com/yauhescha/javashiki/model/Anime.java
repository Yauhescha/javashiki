package com.yauhescha.javashiki.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//TODO: update all commented field
public class Anime {

    @SerializedName("id")
    @Expose
    public Long id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("russian")
    @Expose
    public String russian;

    @SerializedName("image")
    @Expose
    public Image image;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("kind")
    @Expose
    public String kind;

    @SerializedName("score")
    @Expose
    public String score;

    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("episodes")
    @Expose
    public Long episodes;

    @SerializedName("episodes_aired")
    @Expose
    public Long episodesAired;

    @SerializedName("aired_on")
    @Expose
    public String airedOn;

    @SerializedName("released_on")
    @Expose
    public String releasedOn;

    @SerializedName("rating")
    @Expose
    public String rating;

    @SerializedName("english")
    @Expose
    public List<String> english = new ArrayList<>();

    @SerializedName("japanese")
    @Expose
    public List<String> japanese = new ArrayList<>();

    @SerializedName("synonyms")
    @Expose
    public List<String> synonyms = new ArrayList<>();

    @SerializedName("license_name_ru")
    @Expose
    public String  licenseNameRu;

    @SerializedName("duration")
    @Expose
    public Long duration;

    @SerializedName("description")
    @Expose
    public String  description;

    @SerializedName("description_html")
    @Expose
    public String descriptionHtml;

//    @SerializedName("description_source")
//    @Expose
//    public Object descriptionSource;

    @SerializedName("franchise")
    @Expose
    public String franchise;

    @SerializedName("favoured")
    @Expose
    public Boolean favoured;

    @SerializedName("anons")
    @Expose
    public Boolean anons;

    @SerializedName("ongoing")
    @Expose
    public Boolean ongoing;

    @SerializedName("thread_id")
    @Expose
    public Long threadId;

    @SerializedName("topic_id")
    @Expose
    public Long topicId;

    @SerializedName("myanimelist_id")
    @Expose
    public Long myanimelistId;

    @SerializedName("rates_scores_stats")
    @Expose
    public List<RatesScoresStat> ratesScoresStats = new ArrayList<>();

    @SerializedName("rates_statuses_stats")
    @Expose
    public List<RatesStatusesStat> ratesStatusesStats = new ArrayList<>();

    @SerializedName("updated_at")
    @Expose
    public String updatedAt;

//    @SerializedName("next_episode_at")
//    @Expose
//    public Object nextEpisodeAt;

    @SerializedName("fansubbers")
    @Expose
    public List<String> fansubbers = new ArrayList<>();
    
    @SerializedName("fandubbers")
    @Expose
    public List<String> fandubbers = new ArrayList<>();
    
    @SerializedName("licensors")
    @Expose
    public List<String> licensors = new ArrayList<>();

    @SerializedName("genres")
    @Expose
    public List<Genre> genres = new ArrayList<>();

    @SerializedName("studios")
    @Expose
    public List<Studio> studios = new ArrayList<>();
    
    @SerializedName("videos")
    @Expose
    public List<Video> videos = new ArrayList<>();
    
    @SerializedName("screenshots")
    @Expose
    public List<Screenshot> screenshots = new ArrayList<>();
    
//    @SerializedName("user_rate")
//    @Expose
//    public Object userRate;

}