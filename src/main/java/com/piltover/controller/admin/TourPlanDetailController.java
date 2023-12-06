package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.TourPlanDetail;
import com.piltover.service.TourPlanDetailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class TourPlanDetailController {
    @Autowired
    TourPlanDetailService tourPlanDetailService;

    @GetMapping("/tour_plan_detail/all")
    public ResponseEntity<List<TourPlanDetail>> getAllTourPlans() {
        return ResponseEntity.ok(tourPlanDetailService.getAll());
    }

    @GetMapping("/tour_plan_detail/{tourDetailId}")
    public ResponseEntity<TourPlanDetail> getTourPlanDetail(@PathVariable("tourDetailId") Long tourDetailId) {
        return ResponseEntity.ok(tourPlanDetailService.getById(tourDetailId));
    }

    @GetMapping("/tour_plan_detail")
    public ResponseEntity<List<TourPlanDetail>> getAllTourPlans(@RequestParam("tourPlanId") Long id) {
        return ResponseEntity.ok(tourPlanDetailService.getTourPlanDetailListByTourPlanId(id));
    }

    @PostMapping("/admin/tour_plan_detail")
    public void postPlanDetail(@RequestBody TourPlanDetail tourPlanDetail) {
        tourPlanDetailService.postPlanDetail(tourPlanDetail);
    }

    @PutMapping("/admin/tour_plan_detail")
    public void putPlanDetail(@RequestBody TourPlanDetail tourPlanDetail) {
        tourPlanDetailService.putPlanDetail(tourPlanDetail);
    }

    @DeleteMapping("/admin/tour_plan_detail/{tourDetailId}")
    public void deletePlanDetail(@PathVariable("tourDetailId") Long tourPlanDetailId) {
        tourPlanDetailService.deleteTourPlan(tourPlanDetailId);
    }
}