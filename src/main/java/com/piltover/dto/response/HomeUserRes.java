package com.piltover.dto.response;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class HomeUserRes {
	@Id
	private Long tourID;
	private String name_tour;
	private String image;
	private String hotel_name;
	private String hotel_star;
	private String start_address;
	private String start_time;
	private Double adult_price;
	private Double children_price;
	private String transport_name;
}
