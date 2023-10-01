package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Price;
import com.piltover.entity.Tour;
import com.piltover.repository.PriceRepository;
import com.piltover.repository.TourRepository;
import com.piltover.service.TourService;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    TourRepository tourRepository;
    @Autowired
    PriceRepository priceRepository;

    @Override
    public List<Tour> getTourList() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(Long id) {
        return tourRepository.findById(id).get();
    }

    @Override
    public void postTour(Tour tour) {
        Price price = new Price();
        price.setAdultPrice(tour.getPrice().getAdultPrice());
        price.setChildrenPrice(tour.getPrice().getAdultPrice());
        priceRepository.save(price);
        tour.setPrice(price);
        tourRepository.save(tour);
    }

    @Override
    public void putTour(Tour tour) {
        Price price = priceRepository.findById(tour.getPrice().getId()).get();
        price.setAdultPrice(tour.getPrice().getAdultPrice());
        price.setChildrenPrice(tour.getPrice().getChildrenPrice());
        priceRepository.save(price);
        tourRepository.save(tour);
    }

    @Override
    public void deleteTour(Long id) {
        Tour tour = tourRepository.findById(id).get();
        tourRepository.delete(tour);
    }

}
