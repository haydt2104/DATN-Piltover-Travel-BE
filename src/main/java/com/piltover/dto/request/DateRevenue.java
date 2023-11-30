package com.piltover.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class DateRevenue {
	private Date startDate;
	private Date endDate;
}
