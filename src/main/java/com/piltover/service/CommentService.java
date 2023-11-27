package com.piltover.service;

import java.util.List;

import com.piltover.entity.Comment;

public interface CommentService {

	List<Comment> getCommentPost(Long id);
	
	Comment addComment(Comment entity);
	
	Comment removeComment(Comment entity);
	
	Comment fimdCommentById(Long id);
	
	Comment updateComment(Comment entity);
}
