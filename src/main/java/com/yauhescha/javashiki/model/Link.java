package com.yauhescha.javashiki.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Link {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("source_id")
    @Expose
    private Long sourceId;

    @SerializedName("target_id")
    @Expose
    private Long targetId;

    @SerializedName("source")
    @Expose
    private Long source;

    @SerializedName("target")
    @Expose
    private Long target;

    @SerializedName("weight")
    @Expose
    private Long weight;

    @SerializedName("relation")
    @Expose
    private String relation;

}