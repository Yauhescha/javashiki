package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Review;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ReviewApiTest extends CommonTestData {

    private static final String REVIEW_BODY = "This is a test review body that needs to be at least 230 characters long. " +
        "The Shikimori API requires a minimum length for review bodies to ensure quality content. " +
        "Adding more text here to make sure we have enough characters for the test to succeed.";

    private boolean hasReviewsScope = false;

    @Before
    public void checkScope() {
        Map<String, Object> reviewParams = new HashMap<>();
        reviewParams.put("anime_id", "20");
        reviewParams.put("body", REVIEW_BODY);
        reviewParams.put("opinion", "positive");

        Review review = reviewApi.createReview(reviewParams);
        hasReviewsScope = (review != null && review.getId() != null);
        if (hasReviewsScope) {
            reviewApi.deleteReview(review.getId());
        }
    }

    @Test
    public void createUpdateDeleteReview() {
        Assume.assumeTrue("Token needs reviews scope", hasReviewsScope);
        Map<String, Object> reviewParams = new HashMap<>();
        reviewParams.put("anime_id", "20");
        reviewParams.put("body", REVIEW_BODY);
        reviewParams.put("opinion", "positive");

        Review review = reviewApi.createReview(reviewParams);
        assertNotNull(review);
        assertNotNull(review.getId());

        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("body", REVIEW_BODY + " Updated.");
        Review updated = reviewApi.updateReview(review.getId(), updateParams);
        assertNotNull(updated);

        reviewApi.deleteReview(review.getId());
    }
}
