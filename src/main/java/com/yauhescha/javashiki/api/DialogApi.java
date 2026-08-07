package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Dialog;
import com.yauhescha.javashiki.model.domen.message.Message;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class DialogApi {
    private final AuthShikimori auth;

    public List<Dialog> getDialogs() {
        Dialog[] dialogs = new ApiRequest<>(auth, Dialog[].class)
                .execute(GET, METHOD_DIALOGS_GET);
        if (dialogs == null) {
            return List.of();
        }
        return Arrays.asList(dialogs);
    }

    public List<Message> getDialog(String userId) {
        Message[] messages = new ApiRequest<>(auth, Message[].class)
                .execute(GET, String.format(METHOD_DIALOGS_GET_ID, userId));
        if (messages == null) {
            return List.of();
        }
        return Arrays.asList(messages);
    }

    public void deleteDialog(String userId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_DIALOGS_GET_ID, userId));
    }
}
