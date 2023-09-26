package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Tour;
import com.piltover.repository.TourRepository;
import com.piltover.service.TourService;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    TourRepository tourRepository;

    @Override
    public List<Tour> getTourList() {
        return tourRepository.findAll();
    }

    
}
