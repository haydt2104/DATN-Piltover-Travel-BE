package com.piltover.service;

import java.util.List;

import com.piltover.entity.TourPlanDetail;

public interface TourPlanDetailService {
    List<TourPlanDetail> getAll();

    TourPlanDetail getById(Long id);

    List<TourPlanDetail> getTourPlanDetailListByTourPlanId(Long tourPlanId);

    void postPlanDetail(TourPlanDetail planDetail);

    void putPlanDetail(TourPlanDetail planDetail);

    void deleteTourPlan(Long planDetailId);
    
    List<TourPlanDetail> getListById(Long bid);
}