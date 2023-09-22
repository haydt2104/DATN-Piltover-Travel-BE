package com.piltover.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DoanhThu {
	@Id
	private Double totalRevenueTour;
	private Double totalRevenueHotel;

	public DoanhThu(Long totalRevenueTour, Long totalRevenueHotel) {
		this.totalRevenueTour = totalRevenueTour != null ? totalRevenueTour.doubleValue() : null;
		this.totalRevenueHotel = totalRevenueHotel != null ? totalRevenueHotel.doubleValue() : null;
	}
}
