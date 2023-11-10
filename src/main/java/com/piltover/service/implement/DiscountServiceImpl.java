package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.Discount;
import com.piltover.repository.DiscountRepository;
import com.piltover.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
	@Autowired
	DiscountRepository disReps;

	public List<Discount> getAllDiscount() {
		return disReps.findAll();
	}

}
