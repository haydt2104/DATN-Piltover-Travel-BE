package com.piltover.service.implement;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.dto.request.DiscountReq;
import com.piltover.dto.request.Discount_UpdateReq;
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
		return disReps.ReadAllDiscount();
	}

	@Override
	public List<Discount> ReadAllDiscounts1() {
		// TODO Auto-generated method stub
		return disReps.ReadAllDiscount1();
	}

	@Override
	public Discount ReadOneByDiscountID(Long id) {
		// TODO Auto-generated method stub
		return disReps.readOneByDiscountNoDelete(id);
	}

	@Override
	public void createDiscount(Discount bean) {
		Discount discount = bean;
		disReps.save(discount);
	}

	// @Override
	// public Discount updateDiscount(Discount bean) {
	// // TODO Auto-generated method stub
	// return disReps.saveAndFlush(bean);
	// }

	@Override
	public void deleteDiscount(Long id, Long upUser) {
		disReps.deleteDiscount(id, upUser);
	}

	@Override
	public void insertDiscount(DiscountReq bean) {
		disReps.insertDiscount(bean);

	}

	@Override
	public void updateDiscount2(Long id, Discount_UpdateReq discountDTO) {
		// TODO Auto-generated method stub
		disReps.updateDiscount1(id, discountDTO);
	}

	@Override
	public Integer checkAmountById(Long id) {
		// TODO Auto-generated method stub
		return disReps.checkAmount(id);
	}

	@Override
	public void activeDiescount(Long id, Long upUser) {
		// TODO Auto-generated method stub
		disReps.activeDiscount(id, upUser);
	}

	@Override
	public Discount addAmount(Long id, int num) {
		return disReps.addAmount(id, num);

	}

	@Override
	public Boolean checkDelete(Long id) {
		// TODO Auto-generated method stub
		return disReps.check_delete(id);
	}

	@Override
	public Discount getDiscountByCode(String code) {
		return disReps.getDiscountByCode(code);
	}

}
