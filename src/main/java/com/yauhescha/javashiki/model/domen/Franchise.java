package com.yauhescha.javashiki.model.domen;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Franchise {

    @SerializedName("links")
    @Expose
    private List<Link> links = new ArrayList<>();

    @SerializedName("nodes")
    @Expose
    private List<Node> nodes = new ArrayList<>();

    @SerializedName("current_id")
    @Expose
    private Long currentId;

}