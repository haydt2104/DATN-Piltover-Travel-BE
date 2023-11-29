package com.piltover.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.piltover.entity.History;

public interface HistoryService {

	public History getHistoryBookingAcc(String p_uname, Long p_bookingid);

}
