package com.piltover.service.implement;

import java.util.Date;
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

    @Override
    public void postTransport(Transport transport) {
        transportRepository.save(transport);
    }

    @Override
    public void putTransport(Transport transport) {
        transport.setUpdateTime(new Date());
        transportRepository.save(transport);
    }

    @Override
    public void deleteTransport(Long transportId) {
        Transport transport = transportRepository.findById(transportId).get();
        transportRepository.delete(transport);
    }

}
