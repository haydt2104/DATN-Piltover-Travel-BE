package com.piltover.repository.revenue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.piltover.model.History;

public interface HistoryRepository extends JpaRepository<History, Void> {

//	@Procedure(name = "History_OfAccount")
	@Query(nativeQuery = true, value = "CALL History_OfAccount(:p_uname, :p_bookingid)")
	History History_OfAccount(@Param("p_uname") String p_uname, @Param("p_bookingid") Long p_bookingid);
}
