package com.yauhescha.javashiki.model.domen.message;

import lombok.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Data
public class MessageLinked implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("topic_url")
    @Expose
    private String topicUrl;

    @SerializedName("thread_id")
    @Expose
    private Integer threadId;

    @SerializedName("topic_id")
    @Expose
    private Integer topicId;
}
