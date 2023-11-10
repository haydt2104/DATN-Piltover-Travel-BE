package com.piltover.service;

import java.util.List;

import com.piltover.entity.Booking;

public interface BookingService {
    List<Booking> getAllBooking();

    List<Booking> getBookingsByTourDateId(Long tourDateId);

	Booking getOneByID(Long id);

	Booking edit(Booking booking);
}
