package com.yauhescha.javashiki.model.reques;

import com.yauhescha.javashiki.constant.MessageType;
import lombok.Builder;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

@Builder
public class UserMessageParameters {

    @Size(min = 1, max = 100000)
    private Integer page;

    @Size(min = 1, max = 100)
    private Integer limit;

    @NonNull
    private MessageType type;

    public Map<String, Object> getSearchParameters() {
        Map<String, Object> parameters = new HashMap<>();
        if (page != null) {
            parameters.put("page", page);
        }
        if (limit != null) {
            parameters.put("limit", limit);
        }
        if (type != null) {
            parameters.put("type", type);
        } else {
            throw new RuntimeException("Message type cannot be null");
        }
        return parameters;
    }

}
