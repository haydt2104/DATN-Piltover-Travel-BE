package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.Post;
import com.piltover.entity.PostImage;

public interface PostRepository extends JpaRepository<Post, Long>{

	@Query(nativeQuery = true, value = "CALL GetAllPosts")
	List<Post> getAllsPost();
	
	@Query(nativeQuery = true, value = "CALL GetRandomPosts")
	List<Post> getRandomPost();
	
	@Query(nativeQuery = true, value = "SELECT Id FROM Posts ORDER BY ID DESC LIMIT 1")
	String idMostNewPost();
}
