package com.piltover.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.piltover.entity.Booking;


public interface BookingService {
    List<Booking> getAllBooking();
    
}
