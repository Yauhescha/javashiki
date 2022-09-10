package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AnimeMangaStatusItem {

    @SerializedName("id")
    @Expose
    private Long id;
   
    @SerializedName("grouped_id")
    @Expose
    private String groupedId;
    
    @SerializedName("name")
    @Expose
    private String name;
    
    @SerializedName("size")
    @Expose
    private Long size;
    
    @SerializedName("type")
    @Expose
    private String type;

}
