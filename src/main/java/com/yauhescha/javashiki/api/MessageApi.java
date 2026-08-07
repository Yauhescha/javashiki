package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.message.Message;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class MessageApi {
    private final AuthShikimori auth;

    public Optional<Message> getMessage(long messageId) {
        Message message = new ApiRequest<>(auth, Message.class)
                .execute(GET, String.format(METHOD_MESSAGES_GET_ID, messageId));
        return Optional.ofNullable(message);
    }

    public Message createMessage(Map<String, Object> messageParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("message", messageParams);
        return new ApiRequest<>(auth, Message.class)
                .execute(POST, METHOD_MESSAGES_GET, params);
    }

    public Message updateMessage(long messageId, Map<String, Object> messageParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("message", messageParams);
        return new ApiRequest<>(auth, Message.class)
                .execute(PATCH, String.format(METHOD_MESSAGES_GET_ID, messageId), params);
    }

    public void deleteMessage(long messageId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_MESSAGES_GET_ID, messageId));
    }

    public void markRead(String ids, boolean isRead) {
        Map<String, Object> params = new HashMap<>();
        if (ids != null) {
            params.put("ids", ids);
        }
        params.put("is_read", isRead ? "1" : "0");
        new ApiRequest<>(auth, Object.class)
                .execute(POST, METHOD_MESSAGES_MARK_READ, params);
    }

    public void readAll(String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        new ApiRequest<>(auth, Object.class)
                .execute(POST, METHOD_MESSAGES_READ_ALL, params);
    }

    public void deleteAll(String type) {
        Map<String, Object> params = new HashMap<>();
        params.put("type", type);
        new ApiRequest<>(auth, Object.class)
                .execute(POST, METHOD_MESSAGES_DELETE_ALL, params);
    }
}
