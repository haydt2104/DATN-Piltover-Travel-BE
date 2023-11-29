package com.piltover.service;

import java.util.List;

import com.piltover.entity.Transport;

public interface TransportService {
    List<Transport> getAllTransports();

    void postTransport(Transport transport);

    void putTransport(Transport transport);

    void deleteTransport(Long transportId);
}
