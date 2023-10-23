package com.piltover.model;

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
public class MonthRevenue {
	@Id
	private String month;
	private Double total_tour_revenue;
	private Double total_hotel_revenue;
	private Double total_transport_revenue;
}
