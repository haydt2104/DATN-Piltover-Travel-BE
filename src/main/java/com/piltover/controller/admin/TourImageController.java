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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.TourImage;
import com.piltover.service.TourImageService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/tour_image")
public class TourImageController {
    @Autowired
    TourImageService tourImageService;

    @GetMapping("")
    public List<TourImage> getImageByTourId(@RequestParam("tourId") Long tourId) {
        return tourImageService.getTourImagesByTourId(tourId);
    }

    @PostMapping("")
    public void postTourImage(@RequestBody TourImage tourImage) {
        tourImageService.postTourImage(tourImage);
    }

    @PutMapping("")
    public void putTourImage(@RequestBody TourImage tourImage) {
        tourImageService.putTourImage(tourImage);
    }

    @DeleteMapping("/{tourId}")
    public void deleteTour(@PathVariable("tourId") Long tourId) {
        tourImageService.deleteTourImage(tourId);
    }
}
