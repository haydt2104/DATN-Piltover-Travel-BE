package com.piltover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.TourPlan;
import com.piltover.service.TourPlanService;

@CrossOrigin("*")
@RestController()
public class TourPlanController {
    @Autowired
    TourPlanService tourPlanService;

    @GetMapping("/api/tour_plan")
    public List<TourPlan> getAllTourPlans(@RequestParam("tourId") Long id) {
        return tourPlanService.getTourPlansByPlanId(id);
    }
}
