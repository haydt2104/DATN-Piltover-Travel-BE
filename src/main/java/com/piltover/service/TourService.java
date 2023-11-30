package com.piltover.service;

import java.util.List;

import com.piltover.dto.response.HomeUserRes;
import com.piltover.entity.Tour;

public interface TourService {
    Tour getTourById(Long id);

    List<Tour> getTourList();

    void postTour(Tour tour);

    void putTour(Tour tour);

    void deleteTour(Long id);
}
