package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long>{

}
