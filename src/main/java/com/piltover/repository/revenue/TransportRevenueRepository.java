package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.model.TransportRevenue;

public interface TransportRevenueRepository extends JpaRepository<TransportRevenue, Long>{
	@Procedure("CallTransportRevenue")
	List<TransportRevenue> CallTransportRevenue(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
