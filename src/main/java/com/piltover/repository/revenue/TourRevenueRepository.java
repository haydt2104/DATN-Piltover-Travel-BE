package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.model.TourRevenue;

public interface TourRevenueRepository extends JpaRepository<TourRevenue, Long>{
	@Procedure("CallTourRevenue")
	List<TourRevenue> CallTourRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}