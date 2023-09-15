package com.piltover.service;

import java.util.List;

import com.piltover.entity.TourPlan;

public interface TourPlanService {
        List<TourPlan> getTourPlansByPlanID(Long tourID);
}
