package com.yauhescha.javashiki.model.domen;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

//TODO: combine character and person in one class
@Data
public class Roles {

    @SerializedName("roles")
    @Expose
    private List<String> roles = new ArrayList<>();

    @SerializedName("roles_russian")
    @Expose
    private List<String> rolesRussian = new ArrayList<>();

    @SerializedName("character")
    @Expose
    private Character character;

    @SerializedName("person")
    @Expose
    private Person person;

}