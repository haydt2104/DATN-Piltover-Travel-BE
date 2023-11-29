package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query("SELECT c FROM Comment c WHERE c.post.id = ?1 and c.isDelete = 0")
	List<Comment> getCommnetPost(Long id);
	
	
}
