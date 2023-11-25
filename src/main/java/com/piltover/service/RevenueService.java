package com.piltover.service;

import java.util.List;

import com.piltover.dto.response.HotelRevenueRes;
import com.piltover.dto.response.MonthRevenueRes;
import com.piltover.dto.response.RevenueRes;
import com.piltover.dto.response.TourRevenueRes;
import com.piltover.dto.response.TransportRevenueRes;


public interface RevenueService {
	List<RevenueRes> getAll(String startDate, String endDate);
	
	List<MonthRevenueRes> getMonthRevenue(String startDate, String endDate);

	List<TourRevenueRes> getTourRevenue(String startDate, String endDate);
	
	List<HotelRevenueRes> getHotelRevenue(String startDate, String endDate);
	
	List<TransportRevenueRes> getTransportRevenue(String startDate, String endDate);
}
