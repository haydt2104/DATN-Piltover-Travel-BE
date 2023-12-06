package com.piltover.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.piltover.dto.response.LoadStartAddress;
import com.piltover.dto.response.LoadTourHomeRes;

public interface HomeRepository extends JpaRepository<LoadTourHomeRes, Long>{
	@Procedure("CallHomeTour")
	List<LoadTourHomeRes> CallHomeTour();
	
	@Procedure("CallHomeTourSearch")
	List<LoadTourHomeRes> CallHomeTourSearch(
			Date date,
            String tourName,
            String startAddress,
            Double minPrice,
            Double maxPrice);
	
	@Procedure("CallStartAddress")
	List<LoadStartAddress> CallStartAddress();
	
}
