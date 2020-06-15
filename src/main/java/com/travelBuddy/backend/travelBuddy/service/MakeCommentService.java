package com.travelBuddy.backend.travelBuddy.service;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

import org.springframework.stereotype.Service;

@Service
public interface MakeCommentService {
    void insertComment(MakeComment mc); 

    void updateUpvote(int  cid);

    void updateDownvote(int  cid);

    MakeComment findCommentById(Long  cid);

    void deleteCommentById(int id);

    List<MakeComment> findAllComments(); 

    AppUser findAppUserByUserId(int id);

    int findUpvoteById(int id);

    int findDownvoteById(int id);
}