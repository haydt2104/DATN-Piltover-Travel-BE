package com.piltover.service;

import java.util.List;

import com.piltover.dto.request.SearchTour;
import com.piltover.dto.response.LoadStartAddress;
import com.piltover.dto.response.LoadTourHomeRes;

public interface LoadTourServicec {
	List<LoadTourHomeRes> getHomeTour();
	
	List<LoadTourHomeRes> getHomeTourSearch(SearchTour tourSearchParams);
	
	List<LoadStartAddress> getStartAddress();
}
