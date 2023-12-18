package com.piltover.dto.request;

import java.util.Date;

import lombok.Data;

@Data
public class ChangeInfoReq {
	private Long id;
	private String fullname;
	private String phone;
	private Date birthday;
	private Boolean gender;
	private String address;
}
