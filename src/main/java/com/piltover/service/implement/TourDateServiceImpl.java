package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Status;
import com.piltover.entity.TourDate;
import com.piltover.repository.StatusRepository;
import com.piltover.repository.TourDateRepository;
import com.piltover.service.TourDateService;

@Service
public class TourDateServiceImpl implements TourDateService {

    @Autowired
    TourDateRepository tourDateRepository;
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<TourDate> getTourDateByTourId(Long Id) {
        return tourDateRepository.getTourDatesByTourId(Id);
    }

    @Override
    public TourDate getTourDate(Long Id) {
        return tourDateRepository.findById(Id).get();
    }

    @Override
    public void postTourDate(TourDate tourDate) {
        Status status = statusRepository.findById(Long.valueOf(1)).get();
        tourDate.setStatus(status);
        tourDateRepository.save(tourDate);
    }

    @Override
    public void putTourDate(TourDate tourDate) {
        tourDateRepository.save(tourDate);
    }

    @Override
    public void deleteTourDate(Long id) {
        TourDate tourDate = tourDateRepository.findById(id).get();
        tourDateRepository.delete(tourDate);
    }

    @Override
    public List<TourDate> getAllDates() {
        return tourDateRepository.findAll();
    }

}
