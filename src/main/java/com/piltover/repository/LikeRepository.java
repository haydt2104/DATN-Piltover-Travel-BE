package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.Like;

public interface LikeRepository extends JpaRepository<Like, Long>{

	@Query(nativeQuery = true, value = "CALL CountLikePost(?)")
	int getCountLikePostId(long id);
	
//	@Query(nativeQuery = true, value = "CALL CheckUserLike(?, ?)")
	@Query("SELECT l.isLike FROM Like l WHERE l.likeUser.id = ?1 AND l.post.id = ?2")
	Boolean checkLikeUser(long userId, long postId);
	
//	@Query(nativeQuery = true, value = "CALL GetLike(?, ?)")
	@Query("SELECT l FROM Like l WHERE l.likeUser.id = ?1 AND l.post.id = ?2")
	Like getLike(long userId, long postId);
}
