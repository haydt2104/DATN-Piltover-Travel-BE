package com.piltover.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Like;
import com.piltover.repository.LikeRepository;
import com.piltover.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeRepository ldao;

	@Override
	public int getCountLikePostId(Long id) {
		return ldao.getCountLikePostId(id);
	}

	@Override
	public Boolean checkUserLike(long userId, long postId) {
		return ldao.checkLikeUser(userId, postId);
	}

	@Override
	public Like doLike(Like entity) {
		return ldao.saveAndFlush(entity);
	}

	@Override
	public Like getLike(long userId, long postId) {
		return ldao.getLike(userId, postId);
	}

	@Override
	public Like newLike(Like entity) {
		return ldao.saveAndFlush(entity);
	}

}
