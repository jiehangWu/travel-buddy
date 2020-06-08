package com.travelBuddy.backend.travelBuddy.service;

import java.util.UUID;

import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

import org.springframework.stereotype.Service;

@Service
public interface MakeCommentService {
    void insertComment(MakeComment mc); 

    void updateUpvote(UUID cid);

    void updateDownvote(UUID cid);

    MakeComment findCommentById(UUID id);
}