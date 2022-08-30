package com.yauhescha.javashiki.model.reques;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ImageResponse {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("preview")
    @Expose
    private String preview;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("bbcode")
    @Expose
    private String bbcode;

}
