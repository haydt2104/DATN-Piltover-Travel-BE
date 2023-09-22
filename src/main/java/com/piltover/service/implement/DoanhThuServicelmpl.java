package com.piltover.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piltover.entity.DoanhThu;
import com.piltover.repository.DoanhThuRepository;
import com.piltover.service.DoanhThuService;

@Service
public class DoanhThuServicelmpl implements DoanhThuService{
	@Autowired
	DoanhThuRepository rep;

	@Override
	public List<DoanhThu> getDoanhThuTourHotel() {
		// TODO Auto-generated method stub	
		return rep.calculateTotalRevenue();
	}
}
