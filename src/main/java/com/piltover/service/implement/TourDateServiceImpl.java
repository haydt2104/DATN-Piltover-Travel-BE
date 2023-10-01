package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.TourDate;
import com.piltover.repository.TourDateRepository;
import com.piltover.service.TourDateService;

@Service
public class TourDateServiceImpl implements TourDateService {

    @Autowired
    TourDateRepository tourDateRepository;

    @Override
    public List<TourDate> getTourDateByTourId(Long Id) {
        return tourDateRepository.getTourDatesByTourId(Id);
    }

}
