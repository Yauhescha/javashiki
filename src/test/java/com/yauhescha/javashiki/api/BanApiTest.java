package com.yauhescha.javashiki.api;


import com.yauhescha.javashiki.model.domen.Ban;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class BanApiTest extends CommonTestData {

    @Test
    public void testGetBans() {
        List<Ban> bans = banApi.getBans();
        Assert.assertNotNull(bans);
        Assert.assertFalse(bans.isEmpty());
        Ban ban = bans.get(0);
        Assert.assertTrue(ban.getId() > 1);
        Assert.assertTrue(ban.getUserId() > 1);
        Assert.assertTrue(ban.getModeratorId() > 1);
    }
}