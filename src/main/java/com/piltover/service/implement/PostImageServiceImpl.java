package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.PostImage;
import com.piltover.repository.PostImageRepository;
import com.piltover.service.PostImageService;
@Service
public class PostImageServiceImpl implements PostImageService{

	@Autowired
	PostImageRepository dao;
	
	@Override
	public PostImage createPostImg(PostImage entity) {
		return dao.saveAndFlush(entity);
	}

	@Override
	public List<PostImage> postImg(Long id) {
		return dao.findImagePost(id);
	}

}
