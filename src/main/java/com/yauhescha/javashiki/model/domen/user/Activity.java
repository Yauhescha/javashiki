package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Activity implements Serializable {

    @SerializedName("name")
    @Expose
    private List<Long> name = new ArrayList<>();

    @SerializedName("value")
    @Expose
    private Long value;
}
