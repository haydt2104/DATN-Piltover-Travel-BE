package com.piltover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/tour_date")
public class TourDateController {
    @Autowired
    TourDateService tourDateService;

    @GetMapping("")
    public List<TourDate> getDateByTourId(@RequestParam("tourId") Long tourId) {
        return tourDateService.getTourDateByTourId(tourId);
    }

    @GetMapping("/{tourDateId}")
    public TourDate getTourDate(@PathVariable("tourDateId") Long tourDateId) {
        return tourDateService.getTourDate(tourDateId);
    }

    @PostMapping("")
    public void postTourDate(@RequestBody TourDate tourDate) {
        tourDateService.postTourDate(tourDate);
    }

    @PutMapping("")
    public void putTourDate(@RequestBody TourDate tourDate) {
        tourDateService.putTourDate(tourDate);
    }

    @DeleteMapping("/{tourDateId}")
    public void deleteTourDate(@PathVariable("tourDateId") Long tourDateId) {
        tourDateService.deleteTourDate(tourDateId);
    }
}
