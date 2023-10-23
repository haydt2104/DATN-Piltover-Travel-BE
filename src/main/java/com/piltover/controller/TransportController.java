package com.piltover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Transport;
import com.piltover.service.TransportService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api/transport")
public class TransportController {
    @Autowired
    TransportService transportService;

    @GetMapping("/all")
    public List<Transport> getAllTransports() {
        return transportService.getAllTransports();
    }
}
