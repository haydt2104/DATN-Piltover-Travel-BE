package com.piltover.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.BookingDetail;
import com.piltover.entity.History;
import com.piltover.repository.BookingDetailRepository;
import com.piltover.repository.revenue.HistoryRepository;
import com.piltover.service.HistoryService;

@Service
@org.springframework.transaction.annotation.Transactional
public class HistoryImpl implements HistoryService {

	@Autowired
	private BookingDetailRepository historyRepository;	

	@Override
	public BookingDetail ReadOne(Long p_uname, Long p_bookingid) {
		// TODO Auto-generated method stub
		return historyRepository.History_ReadOne(p_uname, p_bookingid);
	}

	
}
