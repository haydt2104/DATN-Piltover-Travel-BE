package com.piltover.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.dto.request.SearchTour;
import com.piltover.dto.response.HomeUserRes;
import com.piltover.repository.HomeRepository;
import com.piltover.service.LoadTourServicec;

@Service
public class LoadTourServicelmpl implements LoadTourServicec {
	@Autowired
	HomeRepository homeRepository;

	@Transactional
	@Override
	public List<HomeUserRes> getHomeTour() {
		// TODO Auto-generated method stub
		return homeRepository.CallHomeTour();
	}
	
	@Transactional
	@Override
	public List<HomeUserRes> getHomeTourSearch(SearchTour tourSearchParams) {
		// TODO Auto-generated method stub

		return homeRepository.CallHomeTourSearch(		
	            tourSearchParams.getStartDate(),
	            tourSearchParams.getTourName(),
	            tourSearchParams.getStartAddress(),
	            tourSearchParams.getMinPrice(),
	            tourSearchParams.getMaxPrice()
	        );
	}
}
