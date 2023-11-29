package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.dto.response.RevenueRes;

public interface RevenueRepository extends JpaRepository<RevenueRes, Double> {
	@Procedure("CallTotalRevenue")
	List<RevenueRes> CallTotalRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
