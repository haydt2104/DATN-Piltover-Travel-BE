package com.piltover.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.repository.BookingDetailRepository;
import com.piltover.service.BookingDetailService;

@Service
public class BookingDetailServiceImpl implements BookingDetailService{
    @Autowired BookingDetailRepository BookingDetailRepo;
}
