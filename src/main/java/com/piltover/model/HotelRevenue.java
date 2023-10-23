package com.piltover.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Getter
@Setter
public class HotelRevenue {
	@Id
	private String hotel_name;
	private Double hotel_price;
	private Double total_hotel_revenue;
	private Integer total_hotel_booking;
}
