package com.piltover.service;

import java.util.List;

import com.piltover.entity.Post;

public interface PostService {

	List<Post> getAllPost();
	
	Post getPost(Long id);
	
	Post updatePost(Post entity);
}
