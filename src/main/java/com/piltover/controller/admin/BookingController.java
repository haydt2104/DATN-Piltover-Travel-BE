package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.response.BookingCountResp;
import com.piltover.entity.Booking;
import com.piltover.entity.BookingDetail;
import com.piltover.service.AccountService;
import com.piltover.service.BookingDetailService;
import com.piltover.service.BookingService;
import com.piltover.util.ResponeUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BookingController {
	@Autowired
	private BookingService bs;

	@Autowired
	private BookingDetailService bds;

	@Autowired
	private AccountService accService;

	@Autowired
	ResponeUtil respUtill;

	@GetMapping("/user/booking/all")
	public ResponseEntity<?> ReadAll() {
		return ResponseEntity.ok(bs.Booking_ReadAll());
	}
	@GetMapping("/admin/booking/all")
	public ResponseEntity<?> ReadAll2() {
		return ResponseEntity.ok(bs.Booking_ReadAll());
	}
	@GetMapping("/admin/booking/detail/{bid}")
	public BookingDetail getById(@PathVariable("bid") Long id) {
		return bds.getDetail(id);
	}

	@DeleteMapping("/admin/booking/cancel/{bid}")
	public ResponseEntity<?> editBookingdetail(@PathVariable Long bid) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		int newStatus = 2;
		Long upUser = accService.getId(username);

		bs.cancelBooking(bid, upUser, newStatus);

		respUtill.putRespone("message", "Cancel booking susscess");

		return ResponseEntity.ok(respUtill.getRespone());
	}

	@GetMapping("/admin/booking")
	public ResponseEntity<List<Booking>> getBookingsByTourDate(@RequestParam("tourDateId") Long id) {
		return ResponseEntity.ok(bs.getBookingsByTourDateId(id));
	}

	@PutMapping("/admin/booking/edit")
	public ResponseEntity<Booking> editBooking(@RequestBody Booking booking) {
		return ResponseEntity.ok(this.bs.edit(booking));
	}

	
	//Đếm hết theo status truyền vào
	@RequestMapping("/user/booking/count/{status}")
	public ResponseEntity<?> BookingCount(@PathVariable("status") Integer Status) {
		BookingCountResp result = new BookingCountResp();
		result.setCount(bs.Booking_count(Status));
		return ResponseEntity.ok(result);
	}
	
	//Đếm theo tour_date
	
	@RequestMapping("/user/booking/countbytourdate/{Tour_DateID}")
	public ResponseEntity<?> Booking_CountByTourDateId(@PathVariable("Tour_DateID") Long Tour_DateID) {
		// BookingCountResp result = new BookingCountResp();
		// result.setCount(bs.Booking_CountByTourDateId(Tour_DateID));
		return ResponseEntity.ok(bs.Booking_CountByTourDateId(Tour_DateID));
	}
	
	//Đếm hết theo status 0-1
	@RequestMapping("/user/booking/count")
	public ResponseEntity<?> BookingCount0_1() {
		BookingCountResp result = new BookingCountResp();
		result.setCount(bs.Booking_count0_1());
		return ResponseEntity.ok(result);
	}
}
