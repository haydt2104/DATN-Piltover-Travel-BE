package com.piltover.service;

import java.util.List;

import com.piltover.entity.Booking;

public interface BookingService {

	List<Booking> Booking_ReadAll();

	List<Booking> getBookingsByTourDateId(Long tourDateId);

	void cancelBooking(Long bid, Long upUser, int newStatus);

//	History 
	public List<Booking> ReadAll(Long p_uname);

	Booking edit(Booking booking);

	Integer Booking_count(Integer status);

	Integer Booking_CountByTourDateId(Long Tour_DateID);

	Integer Booking_count0_1();

	List<Long> getOutDatedBooking();

	// ============for send mail(Begin)============
	String FindEmailByBookingID(Long bid);

	String FindUserNameByBookingID(Long bid);

	String FindTourNameByBookingID(Long bid);
	// ============for send mail(End)============
}
