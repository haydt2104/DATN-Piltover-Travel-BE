package com.piltover.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpReq {
	private String email;
	private String phone;
	private String fullname;
	private Date birthday;
	private Boolean gender;
	private String  address;
	private String password;
}
