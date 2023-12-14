package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
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
	void cancelBooking(@Param("bid") Long bid, @Param("upUser") Long upUser, @Param("newStatus") int newStatus);

	// History
	@Transactional
	@Query(value = "CALL History_ReadAll(:p_uname)", nativeQuery = true)
	List<Booking> History_ReadAll(@Param("p_uname") Long p_uname);

	// Dem so Booking theo trang thai
	@Procedure(name = "Booking_Count")
	Integer Booking_count(Integer status);

	// Dem so Booking theo trang thai và tourdate_id
	@Procedure(name = "Booking_CountByTourDateId")
	Integer Booking_CountByTourDateId(@Param("Tour_DateID") Long Tour_DateID);

	// Dem so Booking theo trang thai 0-1
	@Procedure(name = "Booking_Count0_1")
	Integer Booking_count0_1();

	@Transactional
	@Query(value = "select b.* from bookings b ORDER BY b.Create_at  DESC;", nativeQuery = true)
	List<Booking> Booking_ReadAll();

	@Procedure(name = "Booking_Outdated")
	List<Long> Booking_Outdated();

	//===================================================for send mail(Begin)===================================================
	
	@Transactional
	@Query(value = "SELECT accounts.Email\r\n" + "FROM bookings\r\n"
			+ "JOIN accounts ON accounts.ID = bookings.Create_User\r\n" + "WHERE bookings.Id =:bid", nativeQuery = true)
	String FindEmailByBookingID(@Param("bid") Long bid);

	@Transactional
	@Query(value = "SELECT accounts.fullname\r\n" + "	FROM bookings\r\n"
			+ "	JOIN accounts ON accounts.ID = bookings.Create_User\r\n"
			+ "	WHERE bookings.Id =:bid", nativeQuery = true)
	String FindUserNameByBookingID(@Param("bid") Long bid);

	@Transactional
	@Query(value = "SELECT tours.Name\r\n" + "	FROM bookings\r\n"
			+ "	JOIN tour_dates ON tour_dates.ID = bookings.Tour_DateID\r\n"
			+ "	JOIN tours ON tour_dates.TourID = tours.ID\r\n" + "	WHERE bookings.Id =:bid", nativeQuery = true)
	String FindTourNameByBookingID(@Param("bid") Long bid);
	
	//===================================================for send mail(End)===================================================
}
