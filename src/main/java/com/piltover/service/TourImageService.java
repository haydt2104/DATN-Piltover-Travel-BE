package com.piltover.service;

import java.util.List;

import com.piltover.entity.TourImage;

public interface TourImageService {
    List<TourImage> getTourImagesByTourId(Long id);

    void postTourImage(TourImage tourImage);

    void putTourImage(TourImage tourImage);

    void deleteTourImage(Long id);
}
