package com.piltover.service;

import java.util.List;

import com.piltover.entity.Post;

public interface PostService {

	List<Post> getAllPost();
	
	List<Post> getRandomPost();
	
	Post getPost(Long id);
	
	Post updatePost(Post entity);
	
	Post createPost(Post entity);
	
	Post deletePost(Post entity);
	
	String idMostNewPost();
	
}
