package com.piltover.service;

import java.util.List;

import com.piltover.entity.TourPlanDetail;

public interface TourPlanDetailService {
    List<TourPlanDetail> getAll();

    List<TourPlanDetail> getTourPlanDetailListByTourPlanId(Long tourPlanId);
}
