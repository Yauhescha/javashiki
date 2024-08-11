package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CharacterFull implements Serializable {

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

    @SerializedName("altname")
    @Expose
    private String altname;

    @SerializedName("japanese")
    @Expose
    private String japanese;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_html")
    @Expose
    private String descriptionHtml;

    @SerializedName("description_source")
    @Expose
    private String descriptionSource;

    @SerializedName("favoured")
    @Expose
    private Boolean favoured;

    @SerializedName("thread_id")
    @Expose
    private Long threadId;

    @SerializedName("topic_id")
    @Expose
    private Long topicId;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("seyu")
    @Expose
    private List<Seyu> seyu = new ArrayList<>();

    @SerializedName("animes")
    @Expose
    private List<AnimeForCharacter> animes = new ArrayList<>();

    @SerializedName("mangas")
    @Expose
    private List<MangaForCharacter> mangas = new ArrayList<>();

}
