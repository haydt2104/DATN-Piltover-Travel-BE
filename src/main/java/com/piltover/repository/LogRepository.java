package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
