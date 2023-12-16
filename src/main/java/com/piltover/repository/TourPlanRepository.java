package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.piltover.entity.TourPlan;

public interface TourPlanRepository extends JpaRepository<TourPlan, Long>{
    @Query("SELECT p FROM TourPlan p WHERE p.tourDate.id = ?1")
    List<TourPlan> getTourPlansByDateId(Long id);
    
 // for history
 	@Transactional
 	@Query(value = "CALL GetListTourPlan(:bid)", nativeQuery = true)
 	List<TourPlan> getListTourPlanByBookingId(@Param("bid") Long bid);
}
