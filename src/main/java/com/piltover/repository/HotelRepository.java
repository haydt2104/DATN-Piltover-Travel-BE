package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
