package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Transport;
import com.piltover.repository.TransportRepository;
import com.piltover.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService {
    @Autowired
    TransportRepository transportRepository;

    @Override
    public List<Transport> getAllTransports() {
        return transportRepository.findAll();
    }

}
