package com.yauhescha.javashiki.model.domen.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageImage implements Serializable {

    @SerializedName("x160")
    @Expose
    private String x160;

    @SerializedName("x148")
    @Expose
    private String x148;

    @SerializedName("x80")
    @Expose
    private String x80;

    @SerializedName("x64")
    @Expose
    private String x64;

    @SerializedName("x48")
    @Expose
    private String x48;

    @SerializedName("x32")
    @Expose
    private String x32;

    @SerializedName("x16")
    @Expose
    private String x16;

}
