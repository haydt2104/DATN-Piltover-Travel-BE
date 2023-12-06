package com.piltover.service;

import com.piltover.entity.BookingDetail;
import com.piltover.entity.History;

public interface HistoryService {

	public BookingDetail ReadOne(Long p_uname, Long p_bookingid);

	
}
