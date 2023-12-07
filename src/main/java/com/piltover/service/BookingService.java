package com.piltover.service;

import java.util.List;

import com.piltover.entity.Booking;

public interface BookingService {
	
	List<Booking> Booking_ReadAll();

	List<Booking> getBookingsByTourDateId(Long tourDateId);
	
	void cancelBooking(Long bid, Long upUser,int newStatus); 
	
//	History 
	public List<Booking> ReadAll(Long p_uname);
	
	Booking edit(Booking booking);
	
	Integer Booking_count(Integer status);
	Integer Booking_count0_1();
}
