package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Hotel;
import com.piltover.service.HotelService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping("/all")
    public List<Hotel> getListHotel() {
        return hotelService.getAllHotels();
    }

    @PostMapping("")
    public void postHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
    }

    @PutMapping("")
    public void putHotel(@RequestBody Hotel hotel) {
        hotelService.putHotel(hotel);
    }

    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable("hotelId") Long hotelId) {
        hotelService.deleteHotel(hotelId);
    }
}
