package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Booking;
import com.piltover.repository.BookingRepository;
import com.piltover.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository BookingRepo;

    @Override
    public List<Booking> getAllBooking() {
        return BookingRepo.findAll();
    }

    public List<Booking> getAllBookingComfirmed() {
        return BookingRepo.findAllConfirmed();
    }

    public List<Booking> getAllBookingUnComfirm() {
        return BookingRepo.findAllUnConfirm();
    }

    public List<Booking> getAllBookingCancel() {
        return BookingRepo.findAllCancel();
    }
}
