package com.piltover.dto.request;

import java.io.Serializable;

import lombok.Data;
@Data
public class DiscountReq implements Serializable {
	String name;
	float percentage;
	int amount;
	Long create_User;
	float min;
	float max;

}
