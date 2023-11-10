package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Discount;
import com.piltover.service.implement.DiscountServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/discount")
public class DiscountController {
	@Autowired
	DiscountServiceImpl disImpl;

	@GetMapping("/")
	public List<Discount> getListDiscount() {
		return disImpl.getAllDiscount();
	}
}
