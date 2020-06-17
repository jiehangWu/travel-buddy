package com.travelBuddy.backend.travelBuddy.dao;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

public interface MakeCommentDao {
    void insertComment(MakeComment mc); 

    void updateUpvote(int cid);

    void updateDownvote(int cid);

    MakeComment findCommentById(Long cid);

    void deleteCommentById(int cid);

    List<MakeComment> findAllComments();

    List<MakeComment> findComments(String lat, String lng);

    AppUser findAppUserByUserId(int id);

    int findUpvoteById(int id);

    int findDownvoteById(int id);
}