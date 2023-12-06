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

import com.piltover.entity.TourDate;
import com.piltover.service.TourDateService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class TourDateController {
    @Autowired
    TourDateService tourDateService;

    @GetMapping("/tour_date")
    public ResponseEntity<List<TourDate>> getDateByTourId(@RequestParam("tourId") Long tourId) {
        return ResponseEntity.ok(tourDateService.getTourDateByTourId(tourId));
    }

    @GetMapping("/tour_date/{tourDateId}")
    public ResponseEntity<TourDate> getTourDate(@PathVariable("tourDateId") Long tourDateId) {
        return ResponseEntity.ok(tourDateService.getTourDate(tourDateId));
    }

    @PostMapping("/admin/tour_date")
    public void postTourDate(@RequestBody TourDate tourDate) {
        tourDateService.postTourDate(tourDate);
    }

    @PutMapping("/admin/tour_date")
    public void putTourDate(@RequestBody TourDate tourDate) {
        tourDateService.putTourDate(tourDate);
    }

    @DeleteMapping("/admin/tour_date/{tourDateId}")
    public void deleteTourDate(@PathVariable("tourDateId") Long tourDateId) {
        tourDateService.deleteTourDate(tourDateId);
    }
}
