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

	@Override
	public List<Booking> getAllBooking() {
		return BookingRepo.findAll();
	}

	public Booking getOneByIDQuery(Long Id) {
		return BookingRepo.findByBookingID((Long) Id);
	}
	
	@Override
	public Booking getOneByID(Long id) {
		// TODO Auto-generated method stub
		return BookingRepo.findById(id).get();
	}

	@Override
	public Booking edit(Booking booking) {
		// TODO Auto-generated method stub
		return BookingRepo.save(booking);
	}
	
	@Override
	@Transactional
	public List<Booking> ReadAllHistoryBooking() {
		return BookingRepo.History_ReadAll();
	}

	@Override
	public List<Booking> ReadHistoryByAcc(Long id) {
		// TODO Auto-generated method stub
		return BookingRepo.ReadAllHistoryByAcc(id);
	}

	@Override
	public Booking ReadHistoryByAccAndBid(String uid, Long bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void cancelBooking(Long bid, Long upUser, int newStatus) {
		BookingRepo.cancelBooking(bid, upUser, newStatus);
	}

	
}
