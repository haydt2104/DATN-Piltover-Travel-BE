package com.piltover.service;

import com.piltover.entity.History;

public interface HistoryService {

	public History ReadOne(String p_uname, Long p_bookingid);

	
}
