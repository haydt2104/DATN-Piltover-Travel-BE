package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{

}
