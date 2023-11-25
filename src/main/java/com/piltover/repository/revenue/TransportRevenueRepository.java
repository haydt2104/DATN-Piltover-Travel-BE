package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.dto.response.TransportRevenueRes;

public interface TransportRevenueRepository extends JpaRepository<TransportRevenueRes, Long>{
	@Procedure("CallTransportRevenue")
	List<TransportRevenueRes> CallTransportRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
