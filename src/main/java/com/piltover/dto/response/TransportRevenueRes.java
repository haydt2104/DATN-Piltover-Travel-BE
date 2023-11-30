package com.piltover.dto.response;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity

public class TransportRevenueRes {
	@Id
	private String transport_name;
	private Double transport_price;
	private Double total_transport_revenue;
	private Integer total_transport_booking;
}
