package com.piltover.controller;

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
import com.piltover.entity.Transport;
import com.piltover.service.AccountService;
import com.piltover.service.TransportService;

@CrossOrigin("*")
@RestController()
@RequestMapping("/api")
public class TransportController {
    @Autowired
    TransportService transportService;

    @Autowired
    AccountService accountService;

    @GetMapping("/transport/all")
    public List<Transport> getAllTransports() {
        return transportService.getAllTransports();
    }

    @PostMapping("/admin/transport")
    public void postTransport(@RequestBody Transport transport) {
        transport.setCreateUser(getUser());
        transport.setUpdateUser(getUser());
        transportService.postTransport(transport);
    }

    @PutMapping("/admin/transport")
    public void putTransport(@RequestBody Transport transport) {
        transport.setUpdateUser(getUser());
        transport.setUpdateTime(new Date());
        transportService.putTransport(transport);
    }

    @DeleteMapping("/admin/transport/{id}")
    public void deleteTransport(@PathVariable("id") Long id) {
        transportService.deleteTransport(id);
    }

    public Account getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Long upUser = accountService.getId(username);
        return accountService.findUserByID(upUser);
    }
}
