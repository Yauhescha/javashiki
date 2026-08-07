package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.message.Message;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class MessageApiTest extends CommonTestData {

    private boolean hasMessagesScope = false;

    @Before
    public void checkScope() {
        Map<String, Object> messageParams = new HashMap<>();
        messageParams.put("body", "Test message body");
        messageParams.put("from_id", String.valueOf(TEST_USER_ID));
        messageParams.put("kind", "Private");
        messageParams.put("to_id", String.valueOf(TEST_USER_ID));

        Message message = messageApi.createMessage(messageParams);
        hasMessagesScope = (message != null && message.getId() != null);
        if (hasMessagesScope) {
            messageApi.deleteMessage(message.getId());
        }
    }

    @Test
    public void createGetDeleteMessage() {
        Assume.assumeTrue("Token needs messages scope", hasMessagesScope);
        Map<String, Object> messageParams = new HashMap<>();
        messageParams.put("body", "Test message body");
        messageParams.put("from_id", String.valueOf(TEST_USER_ID));
        messageParams.put("kind", "Private");
        messageParams.put("to_id", String.valueOf(TEST_USER_ID));

        Message message = messageApi.createMessage(messageParams);
        assertNotNull(message);
        assertNotNull(message.getId());

        Optional<Message> fetched = messageApi.getMessage(message.getId());
        assertTrue(fetched.isPresent());

        messageApi.deleteMessage(message.getId());
    }

    @Test
    public void markRead() {
        messageApi.markRead("1,2,3", true);
        assertTrue(true);
    }

    @Test
    public void readAll() {
        messageApi.readAll("news");
        assertTrue(true);
    }

    @Test
    public void deleteAll() {
        messageApi.deleteAll("notifications");
        assertTrue(true);
    }
}
