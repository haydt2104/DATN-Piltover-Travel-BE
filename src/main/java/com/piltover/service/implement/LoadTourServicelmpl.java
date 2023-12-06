package com.piltover.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.dto.request.SearchTour;
import com.piltover.dto.response.LoadStartAddress;
import com.piltover.dto.response.LoadTourHomeRes;
import com.piltover.repository.HomeRepository;
import com.piltover.repository.StartAddressRepository;
import com.piltover.service.LoadTourServicec;

@Service
public class LoadTourServicelmpl implements LoadTourServicec {
	@Autowired
	HomeRepository homeRepository;
	
	@Autowired
	StartAddressRepository startAddressRepository;

	@Transactional
	@Override
	public List<LoadTourHomeRes> getHomeTour() {
		// TODO Auto-generated method stub
		return homeRepository.CallHomeTour();
	}
	
	@Transactional
	@Override
	public List<LoadTourHomeRes> getHomeTourSearch(SearchTour tourSearchParams) {
		// TODO Auto-generated method stub

		return homeRepository.CallHomeTourSearch(		
	            tourSearchParams.getStartDate(),
	            tourSearchParams.getTourName(),
	            tourSearchParams.getStartAddress(),
	            tourSearchParams.getMinPrice(),
	            tourSearchParams.getMaxPrice()
	        );
	}
	
	@Transactional
	@Override
	public List<LoadStartAddress> getStartAddress() {
		// TODO Auto-generated method stub
		return startAddressRepository.CallStartAddress();
	}
}
