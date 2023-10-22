package com.piltover.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
