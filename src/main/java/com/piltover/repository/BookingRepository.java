package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.piltover.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	// Get All data of bookings => (lấy tất cả dữ liệu trong Bookings)
	@Query("SELECT b FROM Booking b")
	List<Booking> findAll();

	// Get All data of bookings with status = 1(confirmed) => (Lấy tất danh sách
	// khách đã liên hệ)
	@Query("SELECT b FROM Booking b WHERE b.status = 1")
	List<Booking> findAllConfirmed();

	// Get All data of bookings with status = 0(unconfirm) => (Lấy tất danh sách
	// khách chưa liên hệ)
	@Query("SELECT b FROM Booking b WHERE b.status = 0")
	List<Booking> findAllUnConfirm();

	// Get All data of bookings with status = 1(confirmed) => (Lấy tất danh sách
	// khách đã hủy)
	@Query("SELECT b FROM Booking b WHERE b.status = 2")
	List<Booking> findAllCancel();

	@Query("SELECT bd FROM Booking bd WHERE bd.id=?1")
	Booking findByBookingID(Long id);
	
	@Transactional
	@Query(value = "CALL FindAllHistory()", nativeQuery = true)
//    @Procedure(name="FindAllHistory")
	List<Booking> History_ReadAll();

	@Modifying
	@Transactional
	@Query(value = "CALL ReadAllHistoryByAcc(:id)", nativeQuery = true)
	List<Booking> ReadAllHistoryByAcc(Long id);

//    @Transactional
//    @Query(value = "CALL ReadOneHistoryByAcc`(:uid,:bid);",nativeQuery = true)
//    Booking ReadoneHistoryByAcc(@Param("uid") Long uid,@Param("bid") Long bid);

}
