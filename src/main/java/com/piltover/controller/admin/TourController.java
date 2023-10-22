package com.piltover.controller.admin;

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
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Tour;
import com.piltover.service.TourService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/tour")
public class TourController {
    @Autowired
    TourService tourService;

    @GetMapping("/all")
    public List<Tour> getAllTour() {
        return tourService.getTourList();
    }

    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable("id") Long tourId) {
        return tourService.getTourById(tourId);
    }

    @PostMapping("")
    public void postTour(@RequestBody Tour tour) {
        tourService.postTour(tour);
    }

    @PutMapping("")
    public void putTour(@RequestBody Tour tour) {
        tourService.putTour(tour);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTour(@PathVariable("tourId") Long tourId) {
        tourService.deleteTour(tourId);
    }
}