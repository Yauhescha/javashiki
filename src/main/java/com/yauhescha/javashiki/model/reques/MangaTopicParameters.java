package com.yauhescha.javashiki.model.reques;

import lombok.Builder;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@Builder
public class MangaTopicParameters {

    @Size(min = 1, max = 100000)
    private Integer page;

    @Size(min = 1, max = 30)
    private Integer limit;

    public Map<String, Object> getSearchParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (page != null) {
            parameters.put("page", page);
        }
        if (limit != null) {
            parameters.put("limit", limit);
        }
        return parameters;
    }

}
