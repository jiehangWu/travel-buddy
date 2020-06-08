package com.travelBuddy.backend.travelBuddy.service;

import java.util.UUID;

import com.travelBuddy.backend.travelBuddy.dao.MakeCommentDao;
import com.travelBuddy.backend.travelBuddy.entity.MakeComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MakeCommentServiceImpl implements MakeCommentService {

    @Autowired
    private MakeCommentDao makeCommentDao;

    @Transactional
	@Override
	public void insertComment(MakeComment mc) {
		makeCommentDao.insertComment(mc);
	}

    @Transactional
	@Override
	public void updateUpvote(UUID cid) {
		makeCommentDao.updateUpvote(cid);
	}

    @Transactional
	@Override
	public void updateDownvote(UUID cid) {
		makeCommentDao.updateDownvote(cid);
	}

    @Transactional
	@Override
	public MakeComment findCommentById(UUID id) {
		return makeCommentDao.findCommentById(id);
	}
}