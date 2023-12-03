package com.piltover.service;


import com.piltover.entity.BookingDetail;

public interface BookingDetailService {
	BookingDetail getDetail(Long bid);

	BookingDetail editDetailOfBooking(BookingDetail bookingDetail);

	BookingDetail edit2(BookingDetail bookingDetail);
}
