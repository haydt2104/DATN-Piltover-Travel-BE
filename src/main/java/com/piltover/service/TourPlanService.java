package com.piltover.service;

import java.util.List;

import com.piltover.entity.TourPlan;

public interface TourPlanService {
        List<TourPlan> getAll();

        TourPlan getById(Long id);

        List<TourPlan> getTourPlansByDateId(Long tourID);

        void postTourPlan(TourPlan plan);

        void putTourPlan(TourPlan plan);

        void deleteTourPlan(Long planId);
        
        List<TourPlan> getTourPlanByBookingID(Long bid);
}
