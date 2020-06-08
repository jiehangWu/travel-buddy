package com.travelBuddy.backend.travelBuddy.dao;

import java.util.UUID;

import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

public interface MakeCommentDao {
    void insertComment(MakeComment mc); 

    void updateUpvote(UUID cid);

    void updateDownvote(UUID cid);

    MakeComment findCommentById(UUID id);
}