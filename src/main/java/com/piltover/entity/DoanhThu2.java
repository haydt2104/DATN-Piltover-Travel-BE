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
public class DoanhThu2 {
	@Id
	private String month;
	private Double totalTour;
	private Double totalHotel;

	public DoanhThu2(String month,Long totalTour, Long totalHotel) {
		this.month = month !=null ? month.toString():null;
		this.totalTour = totalTour != null ? totalTour.doubleValue() : null;
		this.totalHotel = totalHotel != null ? totalHotel.doubleValue() : null;
	}
}
