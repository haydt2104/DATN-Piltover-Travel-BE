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

	@Modifying
	@Query(value = "CALL Booking_Cancel(:bid,:upUser,:newStatus)", nativeQuery = true)
	void cancelBooking(@Param("bid") Long bid, @Param("upUser") Long upUser,@Param("newStatus") int newStatus);

//	History
	@Transactional
	@Query(value = "CALL History_ReadAll(:p_uname)", nativeQuery = true)
	List<Booking> History_ReadAll(@Param("p_uname") Long p_uname);
}
