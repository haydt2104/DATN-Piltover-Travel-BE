package com.piltover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.TourPlanDetail;
import com.piltover.service.TourPlanDetailService;

@RestController
public class TourPlanDetailController {
    @Autowired
    TourPlanDetailService tourPlanDetailService;

    @GetMapping("/api/tour_plan_detail/all")
    public List<TourPlanDetail> getAllTourPlans() {
        return tourPlanDetailService.getAll();
    }

    @GetMapping("/api/tour_plan_detail")
    public List<TourPlanDetail> getAllTourPlans(@RequestParam("tourPlanId") Long id) {
        return tourPlanDetailService.getTourPlanDetailListByTourPlanId(id);
    }
}
