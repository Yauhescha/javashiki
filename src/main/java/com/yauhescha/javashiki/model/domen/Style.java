package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Style implements Serializable {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("owner_id")
    @Expose
    private Long ownerId;

    @SerializedName("owner_type")
    @Expose
    private String ownerType;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("css")
    @Expose
    private String css;

    @SerializedName("compiled_css")
    @Expose
    private String compiledCss;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

}
