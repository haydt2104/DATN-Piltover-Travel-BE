package com.piltover.repository.revenue;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piltover.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long> {

	@Transactional
	@Query(value = "CALL History_ReadOne(:p_uname, :p_bookingid)", nativeQuery = true)
	History History_ReadOne(@Param("p_uname") String p_uname, @Param("p_bookingid") Long p_bookingid);

	
}
