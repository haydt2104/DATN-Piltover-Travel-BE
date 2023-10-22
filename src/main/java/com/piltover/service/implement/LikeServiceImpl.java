package com.piltover.service.implement;

import java.util.List;

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
		// TODO Auto-generated method stub
		return ldao.getCountLikePostId(id);
	}

}
