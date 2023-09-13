package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{

}
