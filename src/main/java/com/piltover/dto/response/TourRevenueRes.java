package com.piltover.dto.response;

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
public class TourRevenueRes {
	@Id
	private String total_name;
	private Double adult_price;
	private Double children_price;
	private Double adult_bookings;
	private Double children_bookings;
	private Double total_revenue;
}
