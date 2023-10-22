package com.piltover.service.implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Booking;
import com.piltover.entity.BookingDetail;
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
	public List<Booking> getAllBooking() {
		return BookingRepo.findAll();
	}

	public List<Booking> getAllBookingComfirmed() {
		return BookingRepo.findAllConfirmed();
	}

	public List<Booking> getAllBookingUnComfirm() {
		return BookingRepo.findAllUnConfirm();
	}

	public List<Booking> getAllBookingCancel() {
		return BookingRepo.findAllCancel();
	}

	public Booking getOneByIDQuery(Long Id) {
		return BookingRepo.findByBookingID((Long) Id);
	}
	

	@Override
	public Booking getOneByID(Long id) {
		// TODO Auto-generated method stub
		return BookingRepo.getOne(id);
	}

	@Override
	public Booking edit(Booking booking) {
		// TODO Auto-generated method stub
		return BookingRepo.save(booking);
	}
}
