package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Topic;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class TopicApiTest extends CommonTestData {

    private boolean hasTopicsScope = false;

    @Before
    public void checkScope() {
        Map<String, Object> topicParams = new HashMap<>();
        topicParams.put("body", "Test topic body");
        topicParams.put("forum_id", "1");
        topicParams.put("title", "Test Topic");
        topicParams.put("type", "Topic");
        topicParams.put("user_id", String.valueOf(TEST_USER_ID));

        Topic topic = topicApi.createTopic(topicParams);
        hasTopicsScope = (topic != null && topic.getId() != null);
        if (hasTopicsScope) {
            topicApi.deleteTopic(topic.getId());
        }
    }

    @Test
    public void getTopics() {
        List<Topic> topics = topicApi.getTopics(1, 5, null, null, null, null);
        assertNotNull(topics);
        assertFalse(topics.isEmpty());
    }

    @Test
    public void getTopicsWithForum() {
        List<Topic> topics = topicApi.getTopics(1, 5, "animanga", null, null, null);
        assertNotNull(topics);
    }

    @Test
    public void getUpdates() {
        List<Topic> updates = topicApi.getUpdates(1, 5);
        assertNotNull(updates);
    }

    @Test
    public void getHotTopics() {
        List<Topic> hot = topicApi.getHotTopics(5);
        assertNotNull(hot);
    }

    @Test
    public void getTopic() {
        List<Topic> topics = topicApi.getTopics(1, 1, null, null, null, null);
        if (!topics.isEmpty()) {
            Optional<Topic> topic = topicApi.getTopic(topics.get(0).getId());
            assertTrue(topic.isPresent());
        }
    }

    @Test
    public void createUpdateDeleteTopic() {
        Assume.assumeTrue("Token needs topics scope", hasTopicsScope);
        Map<String, Object> topicParams = new HashMap<>();
        topicParams.put("body", "Test topic body");
        topicParams.put("forum_id", "1");
        topicParams.put("title", "Test Topic");
        topicParams.put("type", "Topic");
        topicParams.put("user_id", String.valueOf(TEST_USER_ID));

        Topic topic = topicApi.createTopic(topicParams);
        assertNotNull(topic);
        assertNotNull(topic.getId());

        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("body", "Updated test topic body");
        Topic updated = topicApi.updateTopic(topic.getId(), updateParams);
        assertNotNull(updated);

        topicApi.deleteTopic(topic.getId());
    }
}
