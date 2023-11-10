package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.model.MonthRevenue;

public interface MonthRevenueRepository extends JpaRepository<MonthRevenue, String> {
	@Procedure("CallMonthTotalRevenue")
	  List<MonthRevenue> callMonthTotalRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
