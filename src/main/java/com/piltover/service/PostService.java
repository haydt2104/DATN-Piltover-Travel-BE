package com.piltover.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.piltover.entity.Post;

public interface PostService {

	List<Post> getAllPost();
	
	Post getPost(Long id);
	
	Post updatePost(Post entity);
	
	Post createPost(Post entity);
	
	Post deletePost(Post entity);
	
	String idMostNewPost();
	
}
