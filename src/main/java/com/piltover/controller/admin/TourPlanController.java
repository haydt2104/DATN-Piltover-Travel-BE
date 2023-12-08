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

import com.piltover.entity.TourPlan;
import com.piltover.service.TourPlanService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class TourPlanController {
    @Autowired
    TourPlanService tourPlanService;

    @GetMapping("/tour_plan/all")
    public ResponseEntity<List<TourPlan>> getAll() {
        return ResponseEntity.ok(tourPlanService.getAll());
    }

    @GetMapping("/tour_plan/{tourPlanId}")
    public ResponseEntity<TourPlan> getTourPlan(@PathVariable("tourPlanId") Long tourPlanId) {
        return ResponseEntity.ok(tourPlanService.getById(tourPlanId));
    }

    @GetMapping("/admin/tour_plan")
    public ResponseEntity<List<TourPlan>> getTourPlansByTourId(@RequestParam("tourDateId") Long id) {
        return ResponseEntity.ok(tourPlanService.getTourPlansByDateId(id));
    }

    @PostMapping("/admin/tour_plan")
    public void postTourPlan(@RequestBody TourPlan tourPlan) {
        tourPlanService.postTourPlan(tourPlan);
    }

    @PutMapping("/admin/tour_plan")
    public void putTourPlan(@RequestBody TourPlan tourPlan) {
        tourPlanService.postTourPlan(tourPlan);
    }

    @DeleteMapping("/admin/tour_plan/{tourPlanId}")
    public void deleteTourPlan(@PathVariable("tourPlanId") Long tourPlanId) {
        tourPlanService.deleteTourPlan(tourPlanId);
    }
}
