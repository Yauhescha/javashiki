package com.yauhescha.javashiki.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

@UtilityClass
public class Utils {
    public final Gson GSON = new GsonBuilder().create();

    public boolean stringNotEmpty(String str) {
        return str != null && str.length() > 0 && !str.equals("null");
    }

    public String readFileText(@NotNull Path path) throws IOException {
        return String.join("\n", Files.readAllLines(path, StandardCharsets.UTF_8));
    }

    public <T> T fromJson(@NotNull String json, @NotNull Class<T> clazz) {
        try {
            System.out.println("from json to class: "+ clazz);
            return GSON.fromJson(json, clazz);
        } catch (Exception e) {
            System.out.format("Error while deserializing json \"%s\" for %s type", e, json, clazz);
            return null;
        }
    }

    @NotNull
    public <T> String toJson(@NotNull T object) {
        return GSON.toJson(object);
    }
}
