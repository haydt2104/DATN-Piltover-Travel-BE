package com.piltover.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public BookingDetail getDetail(Long bid) {
		// TODO Auto-generated method stub
		return BookingDetailRepo.findByBookingID(bid);
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
