package com.piltover.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.request.DateRevenue;
import com.piltover.service.RevenueService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/revenue")
public class RevenueController {
	@Autowired
	RevenueService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
		return ResponseEntity.ok(service.getAll(startDate, endDate));		
	}
	
	@PostMapping("/getAllRevenue")
	public ResponseEntity<?> getAllRevenue(@RequestBody DateRevenue DateRevenue) {
	    return ResponseEntity.ok(service.getAllRevenue(DateRevenue));
	}
	
	@PostMapping("/getAllMonthRevenue")
	public ResponseEntity<?> getAllMonthRevenue(@RequestBody DateRevenue DateRevenue) {
	    return ResponseEntity.ok(service.getAllMonthRevenue(DateRevenue));
	}
	
	@PostMapping("/getTourRevenue")
	public ResponseEntity<?> getTourRevenue(@RequestBody DateRevenue DateRevenue) {
	    return ResponseEntity.ok(service.getTourRevenue(DateRevenue));
	}
	@PostMapping("/getHotelRevenue")
	public ResponseEntity<?> getHotelRevenue(@RequestBody DateRevenue DateRevenue) {
	    return ResponseEntity.ok(service.getHotelRevenue(DateRevenue));
	}
	@PostMapping("/getTransportRevenue")
	public ResponseEntity<?> getTransportRevenue(@RequestBody DateRevenue DateRevenue) {
	    return ResponseEntity.ok(service.getTransportRevenue(DateRevenue));
	}
}
