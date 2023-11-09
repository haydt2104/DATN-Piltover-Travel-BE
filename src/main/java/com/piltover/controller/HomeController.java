package com.piltover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.TourService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/home")
public class HomeController {
	@Autowired
	TourService TourService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getHomeTour() {
		return ResponseEntity.ok(TourService.getHomeTour());
	}
	
}
