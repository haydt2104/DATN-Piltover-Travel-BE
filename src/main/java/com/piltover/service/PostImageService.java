package com.piltover.service;

import java.util.List;

import com.piltover.entity.PostImage;

public interface PostImageService {

	PostImage createPostImg(PostImage entity);
	
	List<PostImage> postImg(Long id);
}
