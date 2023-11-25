package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.piltover.dto.response.HomeUserRes;

public interface HomeRepository extends JpaRepository<HomeUserRes, Long>{
	@Procedure("CallHomeTour")
	List<HomeUserRes> CallHomeTour();
}
