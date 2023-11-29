package com.piltover.service.implement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.History;
import com.piltover.repository.revenue.HistoryRepository;
import com.piltover.service.HistoryService;

@Service
@org.springframework.transaction.annotation.Transactional
public class HistoryImpl implements HistoryService {

	@Autowired
	private HistoryRepository historyRepository;
	
	@Transactional
	@Override
	public History getHistoryBookingAcc(String p_uname, Long p_bookingid) {
		return historyRepository.History_OfAccount(p_uname, p_bookingid);
	}

	
}
