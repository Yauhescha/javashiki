package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.constant.TopicKind;
import lombok.Builder;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@Builder
public class AnimeTopicParameters {

    @Size(min = 1, max = 100000)
    private Integer page;

    @Size(min = 1, max = 30)
    private Integer limit;

    private TopicKind kind;

    @Size(min = 1, max = 100000)
    private Integer episode;


    public Map<String, Object> getSearchParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (page != null) {
            parameters.put("page", page);
        }
        if (limit != null) {
            parameters.put("limit", limit);
        }
        if (kind != null) {
            parameters.put("kind", kind);
        }
        if (episode != null) {
            parameters.put("episode", episode);
        }
        return parameters;
    }

}
