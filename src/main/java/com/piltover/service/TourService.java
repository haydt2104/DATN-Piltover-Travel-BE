package com.piltover.service;

import java.util.List;

import com.piltover.entity.Tour;
import com.piltover.model.HomeUser;

public interface TourService {
    Tour getTourById(Long id);

    List<Tour> getTourList();

    void postTour(Tour tour);

    void putTour(Tour tour);

    void deleteTour(Long id);
    
	List<HomeUser> getHomeTour();
	

}
