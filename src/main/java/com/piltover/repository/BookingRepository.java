package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.piltover.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	@Query("SELECT b FROM Booking b WHERE b.tourDate.id = ?1")
	List<Booking> getBookingsByTourDateId(Long tourDateId);

	@Query("SELECT bd FROM Booking bd WHERE bd.id=?1")
	Booking findByBookingID(Long id);

	@Transactional
	@Query(value = "CALL FindAllHistory()", nativeQuery = true)
	// @Procedure(name="FindAllHistory")
	List<Booking> History_ReadAll();

//	@Modifying
//	@Transactional
//	@Query(value = "CALL ReadAllHistoryByAcc(:id)", nativeQuery = true)
//	List<Booking> ReadAllHistoryByAcc(Long id);
	
	@Query(value = "CALL ReadAllHistoryByAcc(:p_uname)", nativeQuery = true)
	List<Booking> ReadAllHistoryByAcc(@Param("p_uname") String p_uname);

	@Modifying
	@Query(value = "CALL CancelBooking(:bid,:upUser,:newStatus)", nativeQuery = true)
	void cancelBooking(@Param("bid") Long bid, @Param("upUser") Long upUser,@Param("newStatus") int newStatus);

}
