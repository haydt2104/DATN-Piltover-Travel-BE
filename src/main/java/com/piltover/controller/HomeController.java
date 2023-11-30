package com.piltover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.request.SearchTour;
import com.piltover.service.LoadTourServicec;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/home")
public class HomeController {
	@Autowired
	LoadTourServicec TourService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getHomeTour() {
		return ResponseEntity.ok(TourService.getHomeTour());
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> searchHomeTour(SearchTour tourSearchParams) {
        return ResponseEntity.ok(TourService.getHomeTourSearch(tourSearchParams));
    }
	
	@PostMapping("/createTour")
	public ResponseEntity<?> createTour(@RequestBody SearchTour tourSearchParams) {
	    return ResponseEntity.ok(TourService.getHomeTourSearch(tourSearchParams));
	}
}
