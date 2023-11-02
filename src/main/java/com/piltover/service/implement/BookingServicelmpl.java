package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Booking;
import com.piltover.repository.BookingRepository;
import com.piltover.service.BookingService;

@Service
public class BookingServicelmpl implements BookingService {
	@Autowired
	BookingRepository rep;

	@Override
	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

	@Override
	public List<Booking> getBookingsByTourDateId(Long tourDateId) {
		return rep.getBookingsByTourDateId(tourDateId);
	}

}
