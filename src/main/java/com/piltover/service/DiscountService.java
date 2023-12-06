package com.piltover.service;

import java.util.List;

import com.piltover.dto.request.DiscountReq;
import com.piltover.dto.request.Discount_UpdateReq;
import com.piltover.entity.Discount;

public interface DiscountService {
	
	List<Discount> ReadAllDiscounts();
	
	Discount ReadOneByDiscountID(Long id);
	
	void insertDiscount(DiscountReq bean);
	
	void createDiscount(Discount bean); 
	
//	Discount updateDiscount(Discount bean);
	
	void deleteDiscount(Long id,Long upUser);
	
	void updateDiscount2(Long id, Discount_UpdateReq discountDTO);
	
	Integer checkAmountById(Long id);
	
	void activeDiescount(Long id,Long upUser);
	
	Discount addAmount(Long id,int num);
	
	Boolean checkDelete(Long id);
}
