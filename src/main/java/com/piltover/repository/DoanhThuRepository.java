package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.piltover.entity.DoanhThu;
import com.piltover.entity.DoanhThu2;

public interface DoanhThuRepository extends JpaRepository<DoanhThu, Long> {
	@Query("SELECT new com.piltover.entity.DoanhThu"
			+ "(SUM(bd.adult * p.adultPrice + bd.children * p.childrenPrice + bd.surcharge),"
			+ " SUM(h.price))"
			+ " FROM com.piltover.entity.BookingDetail "
			+ "bd JOIN bd.booking b JOIN b.tour t JOIN t.price p JOIN b.hotel h")
	List<DoanhThu> calculateTotalRevenue();
	
	@Query("SELECT NEW com.piltover.entity.DoanhThu2"
			+ "(DATE_FORMAT(bd.bookingTime, '%Y-%m'),"
			+ " SUM(h.price),"
			+ " SUM(p.adultPrice * bd.adult + p.childrenPrice * bd.children + bd.surcharge) + SUM(h.price))"
			+ " FROM BookingDetail bd JOIN bd.booking b JOIN b.tour t JOIN t.price p JOIN b.hotel h GROUP BY DATE_FORMAT(bd.bookingTime, '%Y-%m') ORDER BY DATE_FORMAT(bd.bookingTime, '%Y-%m')")
	List<DoanhThu2> MonthTourHotel();
}
