package com.piltover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
