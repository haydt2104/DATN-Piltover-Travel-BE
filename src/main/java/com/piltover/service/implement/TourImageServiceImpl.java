package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.TourImage;
import com.piltover.repository.TourImageRespository;
import com.piltover.service.TourImageService;

@Service
public class TourImageServiceImpl implements TourImageService {

    @Autowired
    TourImageRespository tourImageRespository;

    @Override
    public List<TourImage> getTourImagesByTourId(Long id) {
        return tourImageRespository.getTourImagesByTourId(id);
    }

    @Override
    public void postTourImage(TourImage tourImage) {
        tourImageRespository.save(tourImage);
    }

    @Override
    public void putTourImage(TourImage tourImage) {
        tourImageRespository.save(tourImage);
    }

    @Override
    public void deleteTourImage(Long id) {
        TourImage tourImage = tourImageRespository.findById(id).get();
        tourImageRespository.delete(tourImage);
    }
}
