package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.piltover.entity.Tour;


public interface TourRepository extends JpaRepository<Tour, Long>{
	
}
