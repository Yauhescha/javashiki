package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Topic;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class TopicApi {
    private final AuthShikimori auth;

    public List<Topic> getTopics(Integer page, Integer limit, String forum, Long linkedId, String linkedType, String type) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        if (forum != null) {
            params.put("forum", forum);
        }
        if (linkedId != null) {
            params.put("linked_id", linkedId);
        }
        if (linkedType != null) {
            params.put("linked_type", linkedType);
        }
        if (type != null) {
            params.put("type", type);
        }
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, METHOD_TOPICS_GET, params);
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }

    public List<Topic> getUpdates(Integer page, Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, METHOD_TOPICS_UPDATES, params);
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }

    public List<Topic> getHotTopics(Integer limit) {
        Map<String, Object> params = new HashMap<>();
        if (limit != null) {
            params.put("limit", limit);
        }
        Topic[] topics = new ApiRequest<>(auth, Topic[].class)
                .execute(GET, METHOD_TOPICS_HOT, params);
        if (topics == null) {
            return List.of();
        }
        return Arrays.asList(topics);
    }

    public Optional<Topic> getTopic(long topicId) {
        Topic topic = new ApiRequest<>(auth, Topic.class)
                .execute(GET, String.format(METHOD_TOPICS_GET_ID, topicId));
        return Optional.ofNullable(topic);
    }

    public Topic createTopic(Map<String, Object> topicParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("topic", topicParams);
        return new ApiRequest<>(auth, Topic.class)
                .execute(POST, METHOD_TOPICS_GET, params);
    }

    public Topic updateTopic(long topicId, Map<String, Object> topicParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("topic", topicParams);
        return new ApiRequest<>(auth, Topic.class)
                .execute(PATCH, String.format(METHOD_TOPICS_GET_ID, topicId), params);
    }

    public void deleteTopic(long topicId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_TOPICS_GET_ID, topicId));
    }
}
