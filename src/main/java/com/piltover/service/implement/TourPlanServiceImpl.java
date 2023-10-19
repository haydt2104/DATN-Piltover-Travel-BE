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
    public List<TourPlan> getTourPlansByPlanId(Long tourID) {
        return tourPlanRepository.getTourPlansByPlanId(tourID);
    }

    @Override
    public List<TourPlan> getAll() {
        return tourPlanRepository.findAll();
    }

    @Override
    public TourPlan getById(Long id) {
        return tourPlanRepository.findById(id).get();
    }

    @Override
    public void postTourPlan(TourPlan plan) {
        tourPlanRepository.save(plan);
    }

    @Override
    public void putTourPlan(TourPlan plan) {
        tourPlanRepository.save(plan);
    }

    @Override
    public void deleteTourPlan(Long planId) {
        TourPlan plan = tourPlanRepository.findById(planId).get();
        tourPlanRepository.delete(plan);
    }
}
