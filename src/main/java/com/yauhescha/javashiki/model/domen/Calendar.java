package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Calendar implements Serializable {

    @SerializedName("next_episode")
    @Expose
    private Long nextEpisode;

    @SerializedName("next_episode_at")
    @Expose
    private String nextEpisodeAt;

    @SerializedName("duration")
    @Expose
    private Long duration;

    @SerializedName("anime")
    @Expose
    private Anime anime;

}
