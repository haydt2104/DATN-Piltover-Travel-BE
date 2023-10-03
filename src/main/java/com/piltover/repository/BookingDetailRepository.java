package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.Booking;
import com.piltover.entity.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long>{
	@Query("SELECT bd FROM BookingDetail bd WHERE bd.booking.id=?1")
	List<BookingDetail> findByBookingID(Long id);
}
