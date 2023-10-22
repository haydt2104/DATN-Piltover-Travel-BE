package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.piltover.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	// Get All data of bookings => (lấy tất cả dữ liệu trong Bookings)
    @Query("SELECT b FROM Booking b")
    List<Booking> findAll();
    
    // Get All data of bookings with status = 1(confirmed) => (Lấy tất danh sách khách đã liên hệ)
    @Query("SELECT b FROM Booking b WHERE b.status = 1")
    List<Booking> findAllConfirmed();

    // Get All data of bookings with status = 0(unconfirm) => (Lấy tất danh sách khách chưa liên hệ)
    @Query("SELECT b FROM Booking b WHERE b.status = 0")
    List<Booking> findAllUnConfirm();

    // Get All data of bookings with status = 1(confirmed) => (Lấy tất danh sách khách đã hủy)  
    @Query("SELECT b FROM Booking b WHERE b.status = 2")
    List<Booking> findAllCancel();
    
    @Query("SELECT bd FROM Booking bd WHERE bd.id=?1")
	Booking findByBookingID(Long id);

    
}
