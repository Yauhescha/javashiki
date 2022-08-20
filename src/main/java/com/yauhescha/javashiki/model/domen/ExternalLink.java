
package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
//TODO: update all commented field
public class ExternalLink {

    @SerializedName("id")
    @Expose
    private Long id;
    
    @SerializedName("kind")
    @Expose
    private String kind;
    
    @SerializedName("url")
    @Expose
    private String url;
    
    @SerializedName("source")
    @Expose
    private String source;
    
    @SerializedName("entry_id")
    @Expose
    private Long entryId;
    
    @SerializedName("entry_type")
    @Expose
    private String entryType;
    
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    
//    @SerializedName("imported_at")
//    @Expose
//    private Object importedAt;

}