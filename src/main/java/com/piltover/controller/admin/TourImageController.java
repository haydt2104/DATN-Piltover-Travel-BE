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

import com.piltover.entity.TourImage;
import com.piltover.service.TourImageService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class TourImageController {
    @Autowired
    TourImageService tourImageService;

    @GetMapping("/tour_image")
    public ResponseEntity<List<TourImage>> getImageByTourId(@RequestParam Long tourId) {
        return ResponseEntity.ok(tourImageService.getTourImagesByTourId(tourId));
    }

    @PostMapping("/admin/tour_image")
    public void postTourImage(@RequestBody TourImage tourImage) {
        tourImageService.postTourImage(tourImage);
    }

    @PutMapping("/admin/tour_image")
    public void putTourImage(@RequestBody TourImage tourImage) {
        tourImageService.putTourImage(tourImage);
    }

    @DeleteMapping("/admin/tour_image/{tourId}")
    public void deleteTour(@PathVariable Long tourId) {
        tourImageService.deleteTourImage(tourId);
    }
}
