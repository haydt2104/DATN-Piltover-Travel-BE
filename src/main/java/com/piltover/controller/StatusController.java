package com.piltover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Status;
import com.piltover.service.StatusService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    StatusService statusService;

    @GetMapping("/all")
    public List<Status> getAllTransports() {
        return statusService.gettAllStatus();
    }
}
