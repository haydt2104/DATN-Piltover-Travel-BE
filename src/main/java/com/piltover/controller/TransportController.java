package com.piltover.controller;

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

    @PostMapping("")
    public void postTransport(@RequestBody Transport transport) {
        transportService.postTransport(transport);
    }

    @PutMapping("")
    public void putTransport(@RequestBody Transport transport) {
        transportService.putTransport(transport);
    }

    @DeleteMapping("/{id}")
    public void deleteTransport(@PathVariable("id") Long id) {
        transportService.deleteTransport(id);
    }
}
