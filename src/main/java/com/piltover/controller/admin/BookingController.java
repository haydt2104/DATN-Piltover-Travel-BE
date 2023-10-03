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
import com.piltover.service.BookingService;
import com.piltover.service.implement.BookingDetailServiceImpl;
import com.piltover.service.implement.BookingServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/booking")
public class BookingController {
   @Autowired
	private BookingServiceImpl bs;
   
   @Autowired
   private BookingDetailServiceImpl bds;

   @GetMapping("/")
   public List<Booking> getAll(){
	   return bs.getAllBooking();
   }
   
   @GetMapping("/detail/{id}")
   public List<BookingDetail> getById(@PathVariable("id") Long id) {
	   return bds.getAll((Long) id);
   }
   
   @PutMapping("/")
   public ResponseEntity<BookingDetail> editDetail(@RequestBody BookingDetail bookingdetail){
	   return ResponseEntity.ok(this.bds.editDetailOfBooking(bookingdetail));
   }
}
