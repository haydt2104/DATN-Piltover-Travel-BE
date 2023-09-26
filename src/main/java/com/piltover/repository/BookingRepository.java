package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
