package com.piltover.dto.request;

import lombok.Data;

@Data
public class UserLoginReq {
	private String email;
	private String password;
}
