package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long>{

	@Query("SELECT p FROM PostImage p WHERE p.post.id = ?1")
	List<PostImage> findImagePost(Long idPost);
	
}
