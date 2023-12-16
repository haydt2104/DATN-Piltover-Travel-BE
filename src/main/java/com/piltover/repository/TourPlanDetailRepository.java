package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.piltover.entity.TourPlanDetail;

public interface TourPlanDetailRepository extends JpaRepository<TourPlanDetail, Long> {
	@Query("SELECT p FROM TourPlanDetail p WHERE p.tourPlan.id = ?1")
	List<TourPlanDetail> getTourPlanDetailListByTourPlanId(Long tourPlanId);

	// for history
	@Transactional
	@Query(value = "CALL GetListTourPlan(:bid)", nativeQuery = true)
	List<TourPlanDetail> getListTourPlanDetailByBookingId(@Param("bid") Long bid);
}
