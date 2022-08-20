package com.yauhescha.javashiki.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.yauhescha.javashiki.model.auth.Image;
import lombok.val;

import java.lang.reflect.Type;

public final class ImageDeserializer implements JsonDeserializer<Image> {

    @Override
    public Image deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        val object = json.getAsJsonObject();
        val result = new Image();
        if (object.has("original"))
            result.original = object.getAsJsonPrimitive("original").getAsString();
        if (object.has("preview"))
            result.preview = object.getAsJsonPrimitive("preview").getAsString();
        object.entrySet().stream().filter(entry -> entry.getKey().startsWith("x"))
                .forEach(entry -> result.xSizes.put(entry.getKey(), entry.getValue().getAsString()));
        return result;
    }
}
