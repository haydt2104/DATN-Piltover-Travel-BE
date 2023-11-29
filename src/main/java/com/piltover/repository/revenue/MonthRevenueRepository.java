package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.dto.response.MonthRevenueRes;

public interface MonthRevenueRepository extends JpaRepository<MonthRevenueRes, String> {
	@Procedure("CallMonthTotalRevenue")
	  List<MonthRevenueRes> callMonthTotalRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
