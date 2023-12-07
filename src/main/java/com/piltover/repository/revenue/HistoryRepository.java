package com.piltover.repository.revenue;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long> {

//	@Transactional
//	@Query(value = "CALL History_ReadOne(:p_uname, :p_bookingid)", nativeQuery = true)
//	BookingDetail History_ReadOne(@Param("p_uname") Long p_uname, @Param("p_bookingid") Long p_bookingid);

	
}
