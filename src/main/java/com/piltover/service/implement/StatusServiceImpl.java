package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Status;
import com.piltover.repository.StatusRepository;
import com.piltover.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> gettAllStatus() {
        return statusRepository.findAll();
    }

}
