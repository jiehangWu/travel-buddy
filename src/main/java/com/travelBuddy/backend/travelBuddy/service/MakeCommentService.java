package com.travelBuddy.backend.travelBuddy.service;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.AppUser;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

import org.springframework.stereotype.Service;

@Service
public interface MakeCommentService {
    void insertComment(MakeComment mc); 

    void updateUpvote(Long  cid);

    void updateDownvote(Long  cid);

    MakeComment findCommentById(Long  cid);

    void deleteCommentById(Long id);

    List<MakeComment> findAllComments(); 

    AppUser findAppUserByUserId(Long id);
}