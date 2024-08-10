package com.yauhescha.javashiki.api;


import com.yauhescha.javashiki.model.domen.Ban;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class BanApiTest extends CommonTestData {

    @Test
    public void testGetBans() {
        List<Ban> bans = banApi.getBans();
        assertNotNull(bans);
        assertFalse(bans.isEmpty());
        Ban ban = bans.get(0);
        assertTrue(ban.getId() > 1);
        assertTrue(ban.getUserId() > 1);
        assertTrue(ban.getModeratorId() > 1);
    }
}