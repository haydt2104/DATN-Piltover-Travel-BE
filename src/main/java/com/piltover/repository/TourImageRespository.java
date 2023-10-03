package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.TourImage;

public interface TourImageRespository extends JpaRepository<TourImage, Long> {
    @Query("SELECT p FROM TourImage p WHERE p.tour.id = ?1")
    List<TourImage> getTourImagesByTourId(Long id);
}
