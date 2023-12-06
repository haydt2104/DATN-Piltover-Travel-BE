package com.piltover.dto.request;

import java.io.Serializable;

import lombok.Data;
@Data
public class Discount_UpdateReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	float percentage;
	Long Update_User;
	int amount;
	float min;
	float max;
}
