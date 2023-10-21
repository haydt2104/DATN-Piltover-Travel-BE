package com.piltover.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.model.HotelRevenue;
import com.piltover.model.MonthRevenue;
import com.piltover.model.Revenue;
import com.piltover.model.TourRevenue;
import com.piltover.model.TransportRevenue;
import com.piltover.repository.revenue.HotelRevenueRepository;
import com.piltover.repository.revenue.MonthRevenueRepository;
import com.piltover.repository.revenue.RevenueRepository;
import com.piltover.repository.revenue.TourRevenueRepository;
import com.piltover.repository.revenue.TransportRevenueRepository;
import com.piltover.service.RevenueService;

@Service
public class RevenueServicelmpl implements RevenueService{
	@Autowired
	RevenueRepository RenvenueRep;
	
	@Autowired
	MonthRevenueRepository MonthRep;
	
	@Autowired 
	TourRevenueRepository TourRep;
	
	@Autowired
	HotelRevenueRepository HotelRep;
	
	@Autowired
	TransportRevenueRepository TransportRep;
	
	@Transactional
	@Override
	public List<Revenue> getAll(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return RenvenueRep.CallTotalRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<MonthRevenue> getMonthRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return MonthRep.callMonthTotalRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<TourRevenue> getTourRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return TourRep.CallTourRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<HotelRevenue> getHotelRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return HotelRep.CallHotelRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<TransportRevenue> getTransportRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return TransportRep.CallTransportRevenue(startDate, endDate);
	}
}
