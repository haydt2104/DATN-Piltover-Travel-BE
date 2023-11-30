package com.piltover.dto.response;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class HotelRevenueRes {
	@Id
	private String hotel_name;
	private Double hotel_price;
	private Double total_hotel_revenue;
	private Integer total_hotel_booking;
}
