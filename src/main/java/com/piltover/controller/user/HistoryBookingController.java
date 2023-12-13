package com.piltover.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.AccountService;
import com.piltover.service.BookingService;
import com.piltover.service.HistoryService;
import com.piltover.util.ResponeUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user/history")
public class HistoryBookingController {
	
	@Autowired
	AccountService accService;
	@Autowired
	HistoryService historyService;
	@Autowired
	BookingService bookingService;
	
	@Autowired
	ResponeUtil respUtill;

	@GetMapping("/all")
	private ResponseEntity<?> ReadAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Long id = accService.getId(username);
		return ResponseEntity.ok(bookingService.ReadAll(id));
	}

	// get detail @RequestParam
	@GetMapping("")
	public ResponseEntity<?> ReadOne_Param(@RequestParam(name = "detail") Long bid) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		Long uid=accService.getId(username);

		return ResponseEntity.ok(historyService.ReadOne(uid, bid));
	}

	// get by @pathVarable
	@RequestMapping(value = "/detail/{p_bookingid}")
	public ResponseEntity<?> ReadDetailPathVarable(@PathVariable(name = "p_bookingid") Long p_bookingid) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String mail = auth.getName();
		
		Long uid=accService.getId(mail);
		
		return ResponseEntity.ok(historyService.ReadOne(uid, p_bookingid));
	}
	
	@DeleteMapping("/user/booking/cancel/{bid}")
	public ResponseEntity<?> editBookingdetail(@PathVariable Long bid) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		int newStatus = 2;
		Long upUser = accService.getId(username);

		bookingService.cancelBooking(bid, upUser, newStatus);

		respUtill.putRespone("message", "Cancel booking susscess");

		return ResponseEntity.ok(respUtill.getRespone());
	}

}
