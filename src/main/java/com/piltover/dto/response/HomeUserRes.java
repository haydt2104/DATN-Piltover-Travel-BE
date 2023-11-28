package com.piltover.dto.response;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class HomeUserRes {
	@Id
	private Long TourID;
	private String Name_Tour;
	private String Image;
	private String Hotel_Name;
	private String Hotel_Star;
	private String Start_address;
	private String Start_time;
	private Double Adult_price;
	private Double Children_price;
	private String Transport_Name;
}
