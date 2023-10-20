package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piltover.entity.Post;
import com.piltover.repository.PostRepository;
import com.piltover.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostRepository pdao;
	
	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public Post getPost(Long id) {
		// TODO Auto-generated method stub
		return pdao.getById(id);
	}

	@Override
	public Post updatePost(Post entity) {
		// TODO Auto-generated method stub
		return pdao.saveAndFlush(entity);
	}

	@Override
	public Post createPost(Post entity) {
		// TODO Auto-generated method stub
		return pdao.saveAndFlush(entity);
	}

}
