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
public class TransportRevenue {
	@Id
	private String transport_name;
	private Double transport_price;
	private Double total_transport_revenue;
	private Integer total_transport_booking;
}
