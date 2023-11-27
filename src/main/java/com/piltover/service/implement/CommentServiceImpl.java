package com.piltover.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Comment;
import com.piltover.repository.CommentRepository;
import com.piltover.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository dao;
	
	@Override
	public List<Comment> getCommentPost(Long id) {
		return dao.getCommnetPost(id);
	}

	@Override
	public Comment addComment(Comment entity) {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Comment removeComment(Comment entity) {
		entity.setIsDelete(true);
		return dao.saveAndFlush(entity);
	}

	@Override
	public Comment fimdCommentById(Long id) {
		return dao.getById(id);
	}

	@Override
	public Comment updateComment(Comment entity) {
		entity.setUpdateTime(new Date());
		return dao.saveAndFlush(entity);
	}

	
}
