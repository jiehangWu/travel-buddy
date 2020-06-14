package com.travelBuddy.backend.travelBuddy.dao;

import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

public interface MakeCommentDao {
    void insertComment(MakeComment mc); 

    void updateUpvote(Long cid);

    void updateDownvote(Long cid);

    MakeComment findCommentById(Long cid);

    void deleteCommentById(Long cid);
}