package com.yauhescha.javashiki.model.domen.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("read")
    @Expose
    private Boolean read;

    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("html_body")
    @Expose
    private String htmlBody;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("linked_id")
    @Expose
    private Integer linkedId;

    @SerializedName("linked_type")
    @Expose
    private String linkedType;

    @SerializedName("linked")
    @Expose
    private MessageLinked linked;

    @SerializedName("from")
    @Expose
    private MessageUser from;

    @SerializedName("to")
    @Expose
    private MessageUser to;

}
