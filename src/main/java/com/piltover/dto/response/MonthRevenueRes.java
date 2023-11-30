package com.piltover.dto.response;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MonthRevenueRes {
	@Id
	private String month;
	private Double total_tour_revenue;
	private Double total_hotel_revenue;
	private Double total_transport_revenue;
}
