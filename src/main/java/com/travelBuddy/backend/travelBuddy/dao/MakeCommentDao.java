package com.travelBuddy.backend.travelBuddy.dao;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

public interface MakeCommentDao {
    void insertComment(MakeComment mc); 

    void updateUpvote(Long cid);

    void updateDownvote(Long cid);

    MakeComment findCommentById(Long cid);

    void deleteCommentById(Long cid);

    List<MakeComment> findAllComments();

    AppUser findAppUserByUserId(Long id);
}