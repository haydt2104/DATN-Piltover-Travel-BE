package com.piltover.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piltover.entity.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long>{

}
