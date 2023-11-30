package com.piltover.service;

import java.util.List;

import com.piltover.dto.request.SearchTour;
import com.piltover.dto.response.HomeUserRes;

public interface LoadTourServicec {
	List<HomeUserRes> getHomeTour();
	
	List<HomeUserRes> getHomeTourSearch(SearchTour tourSearchParams);
}
