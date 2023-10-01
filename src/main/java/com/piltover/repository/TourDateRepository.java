package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.TourDate;

public interface TourDateRepository extends JpaRepository<TourDate, Long> {
    @Query("SELECT p FROM TourDate p WHERE p.tour.id = ?1")
    List<TourDate> getTourDatesByTourId(Long id);
}
