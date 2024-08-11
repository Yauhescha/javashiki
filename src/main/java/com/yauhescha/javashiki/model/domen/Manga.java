package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Manga implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;
    
    @SerializedName("name")
    @Expose
    private String name;
    
    @SerializedName("russian")
    @Expose
    private String russian;
    
    @SerializedName("image")
    @Expose
    private Image image;
    
    @SerializedName("url")
    @Expose
    private String url;
    
    @SerializedName("kind")
    @Expose
    private String kind;
    
    @SerializedName("score")
    @Expose
    private String score;
    
    @SerializedName("status")
    @Expose
    private String status;
    
    @SerializedName("volumes")
    @Expose
    private Long volumes;
    
    @SerializedName("chapters")
    @Expose
    private Long chapters;
    
    @SerializedName("aired_on")
    @Expose
    private String airedOn;
    
    @SerializedName("released_on")
    @Expose
    private String releasedOn;

}