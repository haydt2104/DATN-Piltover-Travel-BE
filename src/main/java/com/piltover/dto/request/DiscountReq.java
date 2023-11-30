package com.piltover.dto.request;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.piltover.entity.Account;

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
