package com.piltover.service;

import java.util.List;

import com.piltover.entity.Booking;
import com.piltover.model.History;

public interface BookingService {
    List<Booking> getAllBooking();

    List<Booking> getBookingsByTourDateId(Long tourDateId);

	Booking getOneByID(Long id);

	Booking edit(Booking booking);
	
	List<Booking> ReadAllHistoryBooking();
	
	List<Booking> ReadHistoryByAcc(Long id);
	
	Booking ReadHistoryByAccAndBid(String uid,Long bid);
}
