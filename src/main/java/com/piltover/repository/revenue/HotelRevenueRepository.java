package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.model.HotelRevenue;

public interface HotelRevenueRepository extends JpaRepository<HotelRevenue, Long>{
	@Procedure("CallHotelRevenue")
	List<HotelRevenue> CallHotelRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
