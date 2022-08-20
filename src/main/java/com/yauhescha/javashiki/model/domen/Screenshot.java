package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Screenshot {

    @SerializedName("original")
    @Expose
    private String original;

    @SerializedName("preview")
    @Expose
    private String preview;

}