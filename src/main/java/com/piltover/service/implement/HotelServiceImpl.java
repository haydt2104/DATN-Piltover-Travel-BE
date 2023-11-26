package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Hotel;
import com.piltover.repository.HotelRepository;
import com.piltover.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelReps;

    public List<Hotel> getAllHotels() {
        // TODO Auto-generated method stub
        return hotelReps.findAll();
    }

    public void addHotel(Hotel hotel) {
        hotelReps.save(hotel);
    }

    @Override
    public void putHotel(Hotel hotel) {
        hotelReps.save(hotel);
    }

    @Override
    public void deleteHotel(Long id) {
        Hotel hotel = hotelReps.findById(id).get();
        hotelReps.delete(hotel);
    }
}
