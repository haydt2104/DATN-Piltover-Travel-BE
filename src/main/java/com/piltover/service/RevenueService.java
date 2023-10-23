package com.piltover.service;

import java.util.List;

import com.piltover.model.HotelRevenue;
import com.piltover.model.MonthRevenue;
import com.piltover.model.Revenue;
import com.piltover.model.TourRevenue;
import com.piltover.model.TransportRevenue;

public interface RevenueService {
	List<Revenue> getAll(String startDate, String endDate);
	
	List<MonthRevenue> getMonthRevenue(String startDate, String endDate);

	List<TourRevenue> getTourRevenue(String startDate, String endDate);
	
	List<HotelRevenue> getHotelRevenue(String startDate, String endDate);
	
	List<TransportRevenue> getTransportRevenue(String startDate, String endDate);
}
