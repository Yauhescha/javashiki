package com.yauhescha.javashiki.model.domen.consant;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClubConstant implements Serializable {

    @SerializedName("join_policy")
    @Expose
    private List<String> joinPolicy = new ArrayList<>();

    @SerializedName("comment_policy")
    @Expose
    private List<String> commentPolicy = new ArrayList<>();

    @SerializedName("image_upload_policy")
    @Expose
    private List<String> imageUploadPolicy = new ArrayList<>();

}
