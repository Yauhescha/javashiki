package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.UserRate;
import com.yauhescha.javashiki.model.domen.Notice;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class UserRateApiTest extends CommonTestData {

    private boolean hasUserRatesScope = false;

    @Before
    public void checkScope() {
        Map<String, Object> rateParams = new HashMap<>();
        rateParams.put("user_id", String.valueOf(TEST_USER_ID));
        rateParams.put("target_id", "20");
        rateParams.put("target_type", "Anime");
        rateParams.put("status", "planned");

        UserRate rate = userRateApi.createUserRate(rateParams);
        hasUserRatesScope = (rate != null && rate.getId() != null);
        if (hasUserRatesScope) {
            userRateApi.deleteUserRate(rate.getId());
        }
    }

    @Test
    public void createGetDeleteUserRate() {
        Assume.assumeTrue("Token needs user_rates scope", hasUserRatesScope);
        Map<String, Object> rateParams = new HashMap<>();
        rateParams.put("user_id", String.valueOf(TEST_USER_ID));
        rateParams.put("target_id", "20");
        rateParams.put("target_type", "Anime");
        rateParams.put("status", "completed");
        rateParams.put("score", "10");
        rateParams.put("episodes", "220");

        UserRate rate = userRateApi.createUserRate(rateParams);
        assertNotNull(rate);
        assertNotNull(rate.getId());

        Optional<UserRate> fetched = userRateApi.getUserRate(rate.getId());
        assertTrue(fetched.isPresent());

        userRateApi.deleteUserRate(rate.getId());
    }

    @Test
    public void updateUserRate() {
        Assume.assumeTrue("Token needs user_rates scope", hasUserRatesScope);
        Map<String, Object> rateParams = new HashMap<>();
        rateParams.put("user_id", String.valueOf(TEST_USER_ID));
        rateParams.put("target_id", "20");
        rateParams.put("target_type", "Anime");
        rateParams.put("status", "watching");
        rateParams.put("score", "8");

        UserRate rate = userRateApi.createUserRate(rateParams);
        assertNotNull(rate);
        assertNotNull(rate.getId());

        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("status", "completed");
        updateParams.put("score", "9");
        UserRate updated = userRateApi.updateUserRate(rate.getId(), updateParams);
        assertNotNull(updated);

        userRateApi.deleteUserRate(rate.getId());
    }

    @Test
    public void incrementUserRate() {
        Assume.assumeTrue("Token needs user_rates scope", hasUserRatesScope);
        Map<String, Object> rateParams = new HashMap<>();
        rateParams.put("user_id", String.valueOf(TEST_USER_ID));
        rateParams.put("target_id", "20");
        rateParams.put("target_type", "Anime");
        rateParams.put("status", "watching");
        rateParams.put("episodes", "1");

        UserRate rate = userRateApi.createUserRate(rateParams);
        assertNotNull(rate);
        assertNotNull(rate.getId());

        UserRate incremented = userRateApi.incrementUserRate(rate.getId());
        assertNotNull(incremented);

        userRateApi.deleteUserRate(rate.getId());
    }
}
