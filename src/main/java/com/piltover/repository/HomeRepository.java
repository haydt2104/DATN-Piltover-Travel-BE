package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import com.piltover.model.HomeUser;

public interface HomeRepository extends JpaRepository<HomeUser, Long>{
	@Procedure("CallHomeTour")
	List<HomeUser> CallHomeTour();
}
