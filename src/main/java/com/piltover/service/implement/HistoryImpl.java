package com.piltover.service.implement;

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

	@Override
	public History ReadOne(String p_uname, Long p_bookingid) {
		// TODO Auto-generated method stub
		return historyRepository.History_ReadOne(p_uname, p_bookingid);
	}

	
}
