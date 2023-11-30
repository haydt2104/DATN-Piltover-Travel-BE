package com.piltover.repository.revenue;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.dto.response.HotelRevenueRes;

public interface HotelRevenueRepository extends JpaRepository<HotelRevenueRes, Long>{
	@Procedure("CallHotelRevenue")
	List<HotelRevenueRes> CallHotelRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	@Procedure("CallHotelRevenue")
	List<HotelRevenueRes> CallHotelRevenue(Date startDate, Date endDate);
}
