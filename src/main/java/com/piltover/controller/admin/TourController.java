package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.piltover.entity.Tour;
import com.piltover.service.AccountService;
import com.piltover.service.TourService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class TourController {
    @Autowired
    TourService tourService;

    @Autowired
    AccountService accountService;

    @GetMapping("/tour/all")
    public ResponseEntity<List<Tour>> getAllTour() {
        return ResponseEntity.ok(tourService.getTourList());
    }

    @GetMapping("/tour/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable("id") Long tourId) {
        return ResponseEntity.ok(tourService.getTourById(tourId));
    }

    @PostMapping("/admin/tour")
    public void postTour(@RequestBody Tour tour) {
        tour.setCreator(getUser());
        tourService.postTour(tour);
    }

    @PutMapping("/admin/tour")
    public void putTour(@RequestBody Tour tour) {
        tourService.putTour(tour);
    }

    @DeleteMapping("/admin/tour/{tourId}")
    public void deleteTour(@PathVariable Long tourId) {
        tourService.deleteTour(tourId);
    }

    public Account getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Long upUser = accountService.getId(username);
        return accountService.findUserByID(upUser);
    }
}