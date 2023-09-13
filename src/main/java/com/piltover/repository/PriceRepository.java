package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Long>{

}
