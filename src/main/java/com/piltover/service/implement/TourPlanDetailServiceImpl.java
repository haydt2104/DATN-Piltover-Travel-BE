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
}
