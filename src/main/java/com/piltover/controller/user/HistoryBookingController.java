package com.piltover.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Booking;
import com.piltover.entity.History;
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

	@RequestMapping(value ="/detail/{p_bookingid}")
	public ResponseEntity<?> getHistoryBookingAcc(
//			@PathVariable String p_uname,
			@PathVariable(name="p_bookingid") Long p_bookingid) {
		 historyService authentication = SecurityContextHolder.getContext().getAuthentication();

	        // Lấy tên người đăng nhập
	        String username = authentication.getName();
		History result = hs.getHistoryBookingAcc(username, p_bookingid);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/getlist")
	public ResponseEntity<?> ReadHistoryByAcc() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        // Lấy tên người đăng nhập
	        String username = authentication.getName();
		return ResponseEntity.ok(historyService.ReadAllHistoryByAcc(username));
	}

	@GetMapping("/")
	public Booking ReadHistoryByAccAndBid(@RequestParam(name = "detail") Long bid, @PathVariable String uname) {
//		Booking history=historyService.ReadHistoryByAccAndBid(uid, bid);
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

	        // Lấy tên người đăng nhập
	        String username = authentication.getName();
		return historyService.ReadHistoryByAccAndBid(username, bid);
	}

}
