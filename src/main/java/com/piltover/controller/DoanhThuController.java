package com.piltover.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.DoanhThuService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/test")
public class DoanhThuController {
	@Autowired
	DoanhThuService service;

	@GetMapping("/doanhthu")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(service.getDoanhThuTourHotel());
	}
	
	@GetMapping("/monthdoanhthu")
	public ResponseEntity<?> getDoanhThu(){
		return ResponseEntity.ok(service.getMonthDoanhThu());
	}
}
