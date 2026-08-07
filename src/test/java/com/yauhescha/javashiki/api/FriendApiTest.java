package com.yauhescha.javashiki.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendApiTest extends CommonTestData {

    @Test
    public void addRemoveFriend() {
        friendApi.addFriend(1234567);
        friendApi.removeFriend(1234567);
        assertTrue(true);
    }
}
