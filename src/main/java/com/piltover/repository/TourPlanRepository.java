package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.piltover.entity.TourPlan;

public interface TourPlanRepository extends JpaRepository<TourPlan, Long>{
    @Query("SELECT p FROM TourPlan p WHERE p.tour.id = ?1")
    List<TourPlan> getTourPlansByPlanID(Long id);
}
