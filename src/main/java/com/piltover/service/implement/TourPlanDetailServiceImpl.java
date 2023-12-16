package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.TourPlanDetail;
import com.piltover.repository.TourPlanDetailRepository;
import com.piltover.service.TourPlanDetailService;

@Service
public class TourPlanDetailServiceImpl implements TourPlanDetailService {
    @Autowired
    TourPlanDetailRepository tourPlanDetailRepository;

    @Override
    public List<TourPlanDetail> getTourPlanDetailListByTourPlanId(Long tourPlanId) {
        return tourPlanDetailRepository.getTourPlanDetailListByTourPlanId(tourPlanId);
    }

    @Override
    public List<TourPlanDetail> getAll() {
        return tourPlanDetailRepository.findAll();
    }

    @Override
    public TourPlanDetail getById(Long id) {
        return tourPlanDetailRepository.findById(id).get();
    }

    @Override
    public void postPlanDetail(TourPlanDetail planDetail) {
        tourPlanDetailRepository.save(planDetail);
    }

    @Override
    public void putPlanDetail(TourPlanDetail planDetail) {
        tourPlanDetailRepository.save(planDetail);
    }

    @Override
    public void deleteTourPlan(Long planDetailId) {
        TourPlanDetail tourPlanDetail = tourPlanDetailRepository.findById(planDetailId).get();
        tourPlanDetailRepository.delete(tourPlanDetail);
    }

	@Override
	public List<TourPlanDetail> getListById(Long bid) {
			return tourPlanDetailRepository.getListTourPlanDetailByBookingId(bid);
	}
}
