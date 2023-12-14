package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	
}
