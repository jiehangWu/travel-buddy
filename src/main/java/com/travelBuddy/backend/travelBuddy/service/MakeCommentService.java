package com.travelBuddy.backend.travelBuddy.service;

import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

import org.springframework.stereotype.Service;

@Service
public interface MakeCommentService {
    void insertComment(MakeComment mc); 

    void updateUpvote(Long  cid);

    void updateDownvote(Long  cid);

    MakeComment findCommentById(Long  cid);
}