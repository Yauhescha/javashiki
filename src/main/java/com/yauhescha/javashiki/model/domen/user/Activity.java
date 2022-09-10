package com.yauhescha.javashiki.model.domen.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Activity {

    @SerializedName("name")
    @Expose
    private List<Long> name = new ArrayList<>();

    @SerializedName("value")
    @Expose
    private Long value;
}
