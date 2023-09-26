package com.piltover.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.service.BookingService;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/booking")
public class BookingController {
    @Autowired 
    BookingService bookingService;

    @GetMapping("/getAllBookings")
    public ResponseEntity<?> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBooking());
    }

    // @GetMapping("/getAllBookings")
    // public ResponseEntity<?> getAllBookings() {
    //     return ResponseEntity.ok(bookingService.getAllBooking());
    // }

    // @GetMapping("/getAllBookings")
    // public ResponseEntity<?> getAllBookings() {
    //     return ResponseEntity.ok(bookingService.getAllBooking());
    // }

    // @GetMapping("/getAllBookings")
    // public ResponseEntity<?> getAllBookings() {
    //     return ResponseEntity.ok(bookingService.getAllBooking());
    // }
}
