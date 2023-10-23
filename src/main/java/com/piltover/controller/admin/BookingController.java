package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Booking;
import com.piltover.entity.BookingDetail;
import com.piltover.service.BookingDetailService;
import com.piltover.service.BookingService;
import com.piltover.service.implement.BookingDetailServiceImpl;
import com.piltover.service.implement.BookingServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/booking")
public class BookingController {
	@Autowired
	private BookingService bs;

	@Autowired
	private BookingDetailService bds;

	@GetMapping("/")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(bs.getAllBooking());
	}

	@GetMapping("/detail/{id}")
	public BookingDetail getById(@PathVariable("id") Long id) {
		return bds.getAll(id);
	}

	@GetMapping("/getOne/{id}")
	public Booking GetOne(@PathVariable("id") Long id) {
		return bs.getOneByID(id);
	}

	@PutMapping("/edit")
	public ResponseEntity<Booking> editBooking(@RequestBody Booking booking) {
		return ResponseEntity.ok(this.bs.edit(booking));
	}

	@PutMapping("/edit2")
	public ResponseEntity<BookingDetail> editBookingdetail(@RequestBody BookingDetail booking) {
		return ResponseEntity.ok(this.bds.edit2(booking));
	}
}
