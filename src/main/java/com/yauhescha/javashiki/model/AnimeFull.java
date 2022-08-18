package com.yauhescha.javashiki.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AnimeFull extends Anime{

    @SerializedName("rating")
    @Expose
    private String rating;

    @SerializedName("english")
    @Expose
    private List<String> english = new ArrayList<>();

    @SerializedName("japanese")
    @Expose
    private List<String> japanese = new ArrayList<>();

    @SerializedName("synonyms")
    @Expose
    private List<String> synonyms = new ArrayList<>();

    @SerializedName("license_name_ru")
    @Expose
    private String  licenseNameRu;

    @SerializedName("duration")
    @Expose
    private Long duration;

    @SerializedName("description")
    @Expose
    private String  description;

    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;

//    @SerializedName("description_source")
//    @Expose
//    private Object descriptionSource;

    @SerializedName("franchise")
    @Expose
    private String franchise;

    @SerializedName("favoured")
    @Expose
    private Boolean favoured;

    @SerializedName("anons")
    @Expose
    private Boolean anons;

    @SerializedName("ongoing")
    @Expose
    private Boolean ongoing;

    @SerializedName("thread_id")
    @Expose
    private Long threadId;

    @SerializedName("topic_id")
    @Expose
    private Long topicId;

    @SerializedName("myanimelist_id")
    @Expose
    private Long myanimelistId;

    @SerializedName("rates_scores_stats")
    @Expose
    private List<RatesScoresStat> ratesScoresStats = new ArrayList<>();

    @SerializedName("rates_statuses_stats")
    @Expose
    private List<RatesStatusesStat> ratesStatusesStats = new ArrayList<>();

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

//    @SerializedName("next_episode_at")
//    @Expose
//    private Object nextEpisodeAt;

    @SerializedName("fansubbers")
    @Expose
    private List<String> fansubbers = new ArrayList<>();
    
    @SerializedName("fandubbers")
    @Expose
    private List<String> fandubbers = new ArrayList<>();
    
    @SerializedName("licensors")
    @Expose
    private List<String> licensors = new ArrayList<>();

    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<>();

    @SerializedName("studios")
    @Expose
    private List<Studio> studios = new ArrayList<>();
    
    @SerializedName("videos")
    @Expose
    private List<Video> videos = new ArrayList<>();
    
    @SerializedName("screenshots")
    @Expose
    private List<Screenshot> screenshots = new ArrayList<>();
    
//    @SerializedName("user_rate")
//    @Expose
//    private Object userRate;

}