package com.piltover.service;

import java.util.List;

import com.piltover.entity.TourDate;

public interface TourDateService {

    List<TourDate> getAllDates();

    List<TourDate> getTourDateByTourId(Long Id);

    TourDate getTourDate(Long Id);

    void postTourDate(TourDate tourDate);

    void putTourDate(TourDate tourDate);

    void deleteTourDate(Long id);
}
