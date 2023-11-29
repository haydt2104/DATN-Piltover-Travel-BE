package com.piltover.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Booking;
import com.piltover.model.History;
import com.piltover.service.BookingService;
import com.piltover.service.HistoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/history")
public class HistoryBookingController {
	@Autowired
	BookingService historyService;
	@Autowired
	HistoryService hs;

	@GetMapping("/all")
	public ResponseEntity<?> getHistory() {
		return ResponseEntity.ok(historyService.ReadAllHistoryBooking());
	}

	@RequestMapping(value ="/{p_uname}/detail")
	public ResponseEntity<?> getHistoryBookingAcc(
			@PathVariable String p_uname,
			@RequestParam(name="id") Long p_bookingid) {
		String u = "Dư Trường Hây";
		History result = hs.getHistoryBookingAcc(p_uname, p_bookingid);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> ReadHistoryByAcc(@PathVariable(name = "id") Long id) {
		List<Booking> history = historyService.ReadHistoryByAcc(id);
		return new ResponseEntity<>(history, HttpStatus.OK);
	}

	@GetMapping("/")
	public Booking ReadHistoryByAccAndBid(@RequestParam(name = "detail") Long bid, @PathVariable String uname) {
//		Booking history=historyService.ReadHistoryByAccAndBid(uid, bid);
		String u = "Dư Trường Hây";
		return historyService.ReadHistoryByAccAndBid(u, bid);
	}

}
