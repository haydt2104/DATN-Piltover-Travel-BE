package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.TourPlan;
import com.piltover.repository.TourPlanRepository;
import com.piltover.service.TourPlanService;

@Service
public class TourPlanServiceImpl implements TourPlanService {
    @Autowired
    TourPlanRepository tourPlanRepository;

    @Override
    public List<TourPlan> getTourPlansByPlanID(Long tourID) {
        return tourPlanRepository.getTourPlansByPlanID(tourID);
    }
}
