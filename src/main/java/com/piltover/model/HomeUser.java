package com.piltover.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HomeUser {
	@Id
	private Long TourID;
	private String Name_Tour;
	private String Image;
	private Double Adult_price;
	private Double Children_price;
	private String Departure_Dates;
	private String Name_Transports;
}
