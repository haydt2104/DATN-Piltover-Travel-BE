package com.piltover.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Booking;
import com.piltover.entity.BookingDetail;
import com.piltover.repository.BookingDetailRepository;
import com.piltover.repository.BookingRepository;
import com.piltover.service.BookingDetailService;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {
	@Autowired
	BookingDetailRepository BookingDetailRepo;
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public BookingDetail getAll(Long id) {
		// TODO Auto-generated method stub
		return BookingDetailRepo.findByBookingID(id);
	}

	@Override
	public BookingDetail editDetailOfBooking(BookingDetail bookingDetail) {
		// TODO Auto-generated method stub
		return this.BookingDetailRepo.saveAndFlush(bookingDetail);
	}

	public BookingDetail edit2(BookingDetail bookingDetail) {
		return BookingDetailRepo.save(bookingDetail);
	}

}
