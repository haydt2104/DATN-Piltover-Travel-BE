package com.piltover.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.dto.response.HotelRevenueRes;
import com.piltover.dto.response.MonthRevenueRes;
import com.piltover.dto.response.RevenueRes;
import com.piltover.dto.response.TourRevenueRes;
import com.piltover.dto.response.TransportRevenueRes;
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
	public List<RevenueRes> getAll(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return RenvenueRep.CallTotalRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<MonthRevenueRes> getMonthRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return MonthRep.callMonthTotalRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<TourRevenueRes> getTourRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return TourRep.CallTourRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<HotelRevenueRes> getHotelRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return HotelRep.CallHotelRevenue(startDate, endDate);
	}
	
	@Transactional
	@Override
	public List<TransportRevenueRes> getTransportRevenue(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return TransportRep.CallTransportRevenue(startDate, endDate);
	}
}
