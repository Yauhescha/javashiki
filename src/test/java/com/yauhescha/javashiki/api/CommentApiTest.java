package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Comment;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class CommentApiTest extends CommonTestData {

    private boolean hasCommentsScope = false;

    @Before
    public void checkScope() {
        Map<String, Object> commentParams = new HashMap<>();
        commentParams.put("body", "Test comment");
        commentParams.put("commentable_id", String.valueOf(TEST_USER_ID));
        commentParams.put("commentable_type", "User");
        commentParams.put("is_offtopic", "false");

        Comment comment = commentApi.createComment(commentParams);
        hasCommentsScope = (comment != null && comment.getId() != null);
        if (hasCommentsScope) {
            commentApi.deleteComment(comment.getId());
        }
    }

    @Test
    public void getComments() {
        List<Comment> comments = commentApi.getComments((long) TEST_USER_ID, "User", 1, 5, "0");
        assertNotNull(comments);
    }

    @Test
    public void getComment() {
        List<Comment> comments = commentApi.getComments((long) TEST_USER_ID, "User", 1, 1, "0");
        if (!comments.isEmpty()) {
            Optional<Comment> comment = commentApi.getComment(comments.get(0).getId());
            assertTrue(comment.isPresent());
        }
    }

    @Test
    public void createUpdateDeleteComment() {
        Assume.assumeTrue("Token needs comments scope", hasCommentsScope);
        Map<String, Object> commentParams = new HashMap<>();
        commentParams.put("body", "Test comment");
        commentParams.put("commentable_id", String.valueOf(TEST_USER_ID));
        commentParams.put("commentable_type", "User");
        commentParams.put("is_offtopic", "false");

        Comment comment = commentApi.createComment(commentParams);
        assertNotNull(comment);
        assertNotNull(comment.getId());

        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("body", "Updated test comment");
        Comment updated = commentApi.updateComment(comment.getId(), updateParams);
        assertNotNull(updated);

        commentApi.deleteComment(comment.getId());
    }
}
