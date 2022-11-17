package com.yauhescha.javashiki.model.reques;

import com.yauhescha.javashiki.constant.search.*;
import lombok.Builder;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

//TODO change just enums to set
@Builder
public class AnimeMangaRateParameters {

    @Size(min = 1, max = 100000)
    private Integer page;

    @Size(min = 1, max = 5000)
    private Integer limit;

    private SearchOrderListStatus status;

    private Boolean censored;

    public Map<String, Object> getSearchParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (page != null) {
            parameters.put("page", page);
        }
        if (limit != null) {
            parameters.put("limit", limit);
        }
        if (status != null) {
            parameters.put("status", status);
        }
        if (censored != null) {
            parameters.put("censored", censored);
        }
        return parameters;
    }

}
