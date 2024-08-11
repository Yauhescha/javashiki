package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//ToDO equals hashcode
@Data
public class MangaFull extends Manga implements Serializable {

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
    private String licenseNameRu;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;

    //TODO
//    @Expose
//    @SerializedName("description_source")
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

    @SerializedName("licensors")
    @Expose
    private List<String> licensors = new ArrayList<>();

    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<>();

    @SerializedName("publishers")
    @Expose
    private List<Publisher> publishers = new ArrayList<>();

    //TODO
//    @SerializedName("user_rate")
//    @Expose
//    private Object userRate;

}
