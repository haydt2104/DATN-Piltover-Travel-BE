package com.piltover.service;

import com.piltover.entity.Like;

public interface LikeService {

	int getCountLikePostId(Long id);
	
	Boolean checkUserLike(long userId, long postId);
	
	Like doLike(Like entity);
	
	Like getLike(long userId, long postId);
;}
