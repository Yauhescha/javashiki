package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Dialog;
import com.yauhescha.javashiki.model.domen.message.Message;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DialogApiTest extends CommonTestData {

    @Test
    public void getDialogs() {
        List<Dialog> dialogs = dialogApi.getDialogs();
        assertNotNull(dialogs);
    }

    @Test
    public void getDialog() {
        List<Message> messages = dialogApi.getDialog(TEST_USER_USERNAME);
        assertNotNull(messages);
    }
}
