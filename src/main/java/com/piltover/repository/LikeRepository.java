package com.piltover.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.piltover.entity.Like;

public interface LikeRepository extends Repository<Like, Long>{

	@Query(nativeQuery = true, value = "CALL CountLikePost(?)")
	int getCountLikePostId(long id);
}
