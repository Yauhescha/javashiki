package com.yauhescha.javashiki.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Roles {

    @SerializedName("roles")
    @Expose
    public List<String> roles = new ArrayList<>();

    @SerializedName("roles_russian")
    @Expose
    public List<String> rolesRussian = new ArrayList<>();

    @SerializedName("character")
    @Expose
    public Character character;

    @SerializedName("person")
    @Expose
    public Person person;

}