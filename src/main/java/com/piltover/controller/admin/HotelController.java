package com.piltover.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Account;
import com.piltover.entity.Hotel;
import com.piltover.service.AccountService;
import com.piltover.service.HotelService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @Autowired
    AccountService accountService;

    @GetMapping("/hotel/all")
    public List<Hotel> getListHotel() {
        return hotelService.getAllHotels();
    }

    @PostMapping("/admin/hotel")
    public void postHotel(@RequestBody Hotel hotel) {
        hotel.setCreateUser(getUser());
        hotel.setUpdateUser(getUser());
        hotelService.addHotel(hotel);
    }

    @PutMapping("/admin/hotel")
    public void putHotel(@RequestBody Hotel hotel) {
        hotel.setUpdateUser(getUser());
        hotel.setUpdateTime(new Date());
        hotelService.putHotel(hotel);
    }

    @DeleteMapping("/admin/hotel/{hotelId}")
    public void deleteHotel(@PathVariable Long hotelId) {
        hotelService.deleteHotel(hotelId);
    }

    public Account getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Long upUser = accountService.getId(username);
        return accountService.findUserByID(upUser);
    }
}
