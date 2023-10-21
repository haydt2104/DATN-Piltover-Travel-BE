package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.model.Revenue;

public interface RevenueRepository extends JpaRepository<Revenue, Long>{
	@Procedure("CallTotalRevenue")
	List<Revenue> CallTotalRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
