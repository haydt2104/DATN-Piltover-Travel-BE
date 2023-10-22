package com.piltover.service;

import java.util.List;

import com.piltover.entity.BookingDetail;

public interface BookingDetailService {
	public BookingDetail getAll(Long id);
	public BookingDetail editDetailOfBooking(BookingDetail bookingDetail);
}
