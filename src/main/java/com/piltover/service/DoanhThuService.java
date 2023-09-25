package com.piltover.service;

import java.util.List;

import com.piltover.entity.DoanhThu;
import com.piltover.entity.DoanhThu2;

public interface DoanhThuService {
	List<DoanhThu> getDoanhThuTourHotel();
	
	List<DoanhThu2> getMonthDoanhThu();
}
