package com.piltover.service;

import java.util.List;

import com.piltover.entity.TourDate;

public interface TourDateService {
    List<TourDate> getTourDateByTourId(Long Id);
}
