package com.piltover.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.dto.request.DiscountReq;
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

	@Transactional
	@Override
	public List<Discount> ReadAllDiscounts() {
		// TODO Auto-generated method stub
		return disReps.ReadAllDiscountNoDelete();
	}

	@Override
	public Discount ReadOneByDiscountID(Long id) {
		// TODO Auto-generated method stub
		return disReps.readOneByDiscountNoDelete(id);
	}

	


	@Override
	public void createDiscount(Discount bean) {
		Discount discount=bean;
		 disReps.save(discount);
	}

	@Override
	public Discount updateDiscount(Discount bean) {
		// TODO Auto-generated method stub
		return disReps.saveAndFlush(bean);
	}

	@Override
	public void deleteDiscount(Long id) {
		disReps.deleteDiscount(id);
	}

	@Override
	public void insertDiscount(DiscountReq bean ) {
		disReps.insertDiscount(bean);
		
	}

}
