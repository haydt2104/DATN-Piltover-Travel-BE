package com.piltover.service;

import java.util.List;

import com.piltover.entity.Hotel;

public interface HotelService {
    List<Hotel> getAllHotels();

    void addHotel(Hotel hotel);

    void putHotel(Hotel hotel);

    void deleteHotel(Long id);
}
