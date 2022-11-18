package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AnimeMangaRate {

    @SerializedName("id")
    @Expose
    private Integer id;
    
    @SerializedName("score")
    @Expose
    private Integer score;
    
    @SerializedName("status")
    @Expose
    private String status;
    
    @SerializedName("text")
    @Expose
    private String text;
    
    @SerializedName("episodes")
    @Expose
    private Integer episodes;
    
    @SerializedName("chapters")
    @Expose
    private Integer chapters;
    
    @SerializedName("volumes")
    @Expose
    private Integer volumes;
    
    @SerializedName("text_html")
    @Expose
    private String textHtml;
    
    @SerializedName("rewatches")
    @Expose
    private Integer rewatches;
    
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    
    @SerializedName("user")
    @Expose
    private User user;
    
    @SerializedName("anime")
    @Expose
    private Anime anime;
    
    @SerializedName("manga")
    @Expose
    private Manga manga;

}
