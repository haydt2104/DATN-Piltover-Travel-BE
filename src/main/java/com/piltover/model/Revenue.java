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
public class Revenue {
	@Id
	private Double total_revenue;
	private Double total_tour_revenue;
	private Double total_hotel_revenue;
	private Double total_transport_revenue;
}
