package com.piltover.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.piltover.entity.Like;

public interface LikeRepository extends Repository<Like, Long>{

	@Query(nativeQuery = true, value = "Select count(*) as 'so luong like' from likes"
			+ " where Is_Like = 1 and PostID = ?1")
	int getCountLikePostId(long id);
}
