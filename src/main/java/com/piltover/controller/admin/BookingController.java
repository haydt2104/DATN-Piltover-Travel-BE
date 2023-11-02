package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Booking;
import com.piltover.service.BookingService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/booking")
public class BookingController {
	@Autowired
	BookingService ser;

	@GetMapping("/getAllBookings")
	public ResponseEntity<?> getAllBookings() {
		return ResponseEntity.ok(ser.getAllBooking());
	}

	@GetMapping("")
	public List<Booking> getBookingsByTourDate(@RequestParam("tourDateId") Long id) {
		return ser.getBookingsByTourDateId(id);
	}
}
