package com.piltover.service;

import com.piltover.entity.BookingDetail;

public interface HistoryService {

	public BookingDetail ReadOne(Long p_uname, Long p_bookingid);

	
}
