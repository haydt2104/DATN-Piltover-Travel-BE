package com.piltover.service;

import java.util.List;

import com.piltover.dto.request.DateRevenue;
import com.piltover.dto.response.HotelRevenueRes;
import com.piltover.dto.response.MonthRevenueRes;
import com.piltover.dto.response.RevenueRes;
import com.piltover.dto.response.TourRevenueRes;
import com.piltover.dto.response.TransportRevenueRes;


public interface RevenueService {
	/*
	 * 
	 * 
	 * List<MonthRevenueRes> getMonthRevenue(String startDate, String endDate);
	 * 
	 * List<TourRevenueRes> getTourRevenue(String startDate, String endDate);
	 * 
	 * List<HotelRevenueRes> getHotelRevenue(String startDate, String endDate);
	 * 
	 * List<TransportRevenueRes> getTransportRevenue(String startDate, String
	 * endDate);
	 */
	List<RevenueRes> getAll(String startDate, String endDate);
	List<RevenueRes> getAllRevenue(DateRevenue DateRevenue); 
	
	List<MonthRevenueRes> getAllMonthRevenue(DateRevenue DateRevenue); 
	
	List<TourRevenueRes> getTourRevenue(DateRevenue DateRevenue);
	
	List<HotelRevenueRes> getHotelRevenue(DateRevenue DateRevenue);
	
	List<TransportRevenueRes> getTransportRevenue(DateRevenue DateRevenue);
}
