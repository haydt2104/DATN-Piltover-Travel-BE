package com.piltover.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piltover.entity.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long>{
//	@Query("SELECT bd FROM BookingDetail bd WHERE bd.booking.id=?1")
//	BookingDetail findByBookingID(Long id);
	
	@Transactional
	@Query(value="CALL ReadDetailBooking(:bid)",nativeQuery = true)
	BookingDetail findByBookingID(Long bid);
	
	@Transactional
	@Query(value = "CALL History_ReadOne(:p_uname, :p_bookingid)", nativeQuery = true)
	BookingDetail History_ReadOne(@Param("p_uname") Long p_uname, @Param("p_bookingid") Long p_bookingid);
}
