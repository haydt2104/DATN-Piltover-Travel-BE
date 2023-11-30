package com.piltover.service;

import java.util.List;

import com.piltover.dto.request.DiscountReq;
import com.piltover.entity.Discount;

public interface DiscountService {
	
	List<Discount> ReadAllDiscounts();
	
	Discount ReadOneByDiscountID(Long id);
	
	void insertDiscount(DiscountReq bean);
	
	void createDiscount(Discount bean); 
	
	Discount updateDiscount(Discount bean);
	
	void deleteDiscount(Long id);
	
}
