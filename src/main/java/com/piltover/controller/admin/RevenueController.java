package com.piltover.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.RevenueService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/revenue")
public class RevenueController {
	@Autowired
	RevenueService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){
		return ResponseEntity.ok(service.getAll(startDate, endDate));		
	}
	
	@GetMapping("/getMonthRevenue")
	  public ResponseEntity<?> getMonthRevenue(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
	    return ResponseEntity.ok(service.getMonthRevenue(startDate, endDate));
	}
	
	@GetMapping("/getTourRevenue")	
	public ResponseEntity<?> getTourRevenue(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){	
		return ResponseEntity.ok(service.getTourRevenue(startDate, endDate));
	}
	
	@GetMapping("/getHotelRevenue")	
	public ResponseEntity<?> getHotelRevenue(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){	
		return ResponseEntity.ok(service.getHotelRevenue(startDate, endDate));
	}
	
	@GetMapping("/getTransportRevenue")	
	public ResponseEntity<?> getTransportRevenue(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate){	
		return ResponseEntity.ok(service.getTransportRevenue(startDate, endDate));
	}
}
