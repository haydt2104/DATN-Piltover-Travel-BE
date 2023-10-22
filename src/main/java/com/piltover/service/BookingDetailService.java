package com.piltover.service;


import com.piltover.entity.BookingDetail;

public interface BookingDetailService {
	BookingDetail getAll(Long id);

	BookingDetail editDetailOfBooking(BookingDetail bookingDetail);

	BookingDetail edit2(BookingDetail bookingDetail);
}
