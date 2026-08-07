package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Comment;
import com.yauhescha.javashiki.request.ApiRequest;
import com.yauhescha.javashiki.request.AuthShikimori;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.yauhescha.javashiki.constant.ShikiInfo.*;
import static com.yauhescha.javashiki.request.RequestType.*;

@RequiredArgsConstructor
public class CommentApi {
    private final AuthShikimori auth;

    public List<Comment> getComments(Long commentableId, String commentableType, Integer page, Integer limit, String desc) {
        Map<String, Object> params = new HashMap<>();
        if (commentableId != null) {
            params.put("commentable_id", commentableId);
        }
        if (commentableType != null) {
            params.put("commentable_type", commentableType);
        }
        if (page != null) {
            params.put("page", page);
        }
        if (limit != null) {
            params.put("limit", limit);
        }
        if (desc != null) {
            params.put("desc", desc);
        }
        Comment[] comments = new ApiRequest<>(auth, Comment[].class)
                .execute(GET, METHOD_COMMENTS_GET, params);
        if (comments == null) {
            return List.of();
        }
        return Arrays.asList(comments);
    }

    public Optional<Comment> getComment(long commentId) {
        Comment comment = new ApiRequest<>(auth, Comment.class)
                .execute(GET, String.format(METHOD_COMMENTS_GET_ID, commentId));
        return Optional.ofNullable(comment);
    }

    public Comment createComment(Map<String, Object> commentParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("comment", commentParams);
        return new ApiRequest<>(auth, Comment.class)
                .execute(POST, METHOD_COMMENTS_GET, params);
    }

    public Comment updateComment(long commentId, Map<String, Object> commentParams) {
        Map<String, Object> params = new HashMap<>();
        params.put("comment", commentParams);
        return new ApiRequest<>(auth, Comment.class)
                .execute(PATCH, String.format(METHOD_COMMENTS_GET_ID, commentId), params);
    }

    public void deleteComment(long commentId) {
        new ApiRequest<>(auth, Object.class)
                .execute(DELETE, String.format(METHOD_COMMENTS_GET_ID, commentId));
    }
}
