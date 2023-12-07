package com.piltover.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Booking;
import com.piltover.repository.BookingDetailRepository;
import com.piltover.repository.BookingRepository;
import com.piltover.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository BookingRepo;
	@Autowired
	BookingDetailRepository bookingDetailRepo;

	@Override
	public List<Booking> getBookingsByTourDateId(Long tourDateId) {
		return BookingRepo.getBookingsByTourDateId(tourDateId);
	}

	public Booking getOneByIDQuery(Long Id) {
		return BookingRepo.findByBookingID((Long) Id);
	}

	// dont touch
	@Transactional
	@Override
	public void cancelBooking(Long bid, Long upUser, int newStatus) {
		BookingRepo.cancelBooking(bid, upUser, newStatus);
	}

	// History
	@Override
	public List<Booking> ReadAll(Long p_uname) {
		// TODO Auto-generated method stub
		return BookingRepo.History_ReadAll(p_uname);
	}

	@Override
	public Booking edit(Booking booking) {
		return BookingRepo.save(booking);
	}

	@Override
	public List<Booking> Booking_ReadAll() {
		// TODO Auto-generated method stub
		return BookingRepo.Booking_ReadAll();
	}

	@Override
	public Integer Booking_count(Integer status) {
		// TODO Auto-generated method stub
		return BookingRepo.Booking_count(status);
	}

	@Override
	public Integer Booking_count0_1() {
		// TODO Auto-generated method stub
		return BookingRepo.Booking_count0_1();
	}

	@Override
	public Integer Booking_CountByTourDateId(Long Tour_DateID) {
		return BookingRepo.Booking_CountByTourDateId(Tour_DateID);
	}

}
