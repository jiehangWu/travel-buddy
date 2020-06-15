package com.travelBuddy.backend.travelBuddy.service;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.dao.MakeCommentDao;
import com.travelBuddy.backend.travelBuddy.entity.AppUser;
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
	public void updateUpvote(int cid) {
		makeCommentDao.updateUpvote(cid);
	}

    @Transactional
	@Override
	public void updateDownvote(int  cid) {
		makeCommentDao.updateDownvote(cid);
	}

    @Transactional
	@Override
	public MakeComment findCommentById(Long  cid) {
		return makeCommentDao.findCommentById(cid);
	}

	@Override
	public void deleteCommentById(int id) {
		makeCommentDao.deleteCommentById(id);
	}

	@Override
	public List<MakeComment> findAllComments() {
		return makeCommentDao.findAllComments();
	}

	@Override
	public AppUser findAppUserByUserId(int id) {
		return makeCommentDao.findAppUserByUserId(id);
	}

	@Override
	public int findUpvoteById(int id) {
		return makeCommentDao.findUpvoteById(id);
	}

	@Override
	public int findDownvoteById(int id) {
		return makeCommentDao.findDownvoteById(id);
	}
}