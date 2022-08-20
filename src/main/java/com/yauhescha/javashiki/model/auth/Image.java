package com.yauhescha.javashiki.model.auth;

import com.yauhescha.javashiki.constant.ShikiInfo;
import com.yauhescha.javashiki.util.Utils;
import lombok.ToString;
import lombok.val;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@ToString
public class Image {
    public String original;
    public String preview;

    public final Map<String, String> xSizes = new HashMap<>();

    private String resolve(String value) {
        return value.startsWith("/") ? ShikiInfo.URL_SHIKIMORI + value : value;
    }

    public String getOriginalFull() {
        return resolve(original);
    }

    public String getPreviewFull() {
        return resolve(preview);
    }

    public String getMaxX() {
        val result = xSizes.keySet().stream().map(k -> Integer.parseInt(k.substring(1))).max(Comparator.naturalOrder());
        return xSizes.get(result.map(integer -> "x" + integer).orElse(null));
    }

    public String getMinX() {
        val result = xSizes.keySet().stream().map(k -> Integer.parseInt(k.substring(1))).min(Comparator.naturalOrder());
        return xSizes.get(result.map(integer -> "x" + integer).orElse(null));
    }

    public String getMaxXFull() {
        val result = getMaxX();
        return Utils.stringNotEmpty(result) ? resolve(result) : null;
    }

    public String getMinXFull() {
        val result = getMinX();
        return Utils.stringNotEmpty(result) ? resolve(result) : null;
    }
}
