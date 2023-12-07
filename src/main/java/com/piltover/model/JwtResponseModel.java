package com.piltover.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponseModel implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	private final String token;
	private String email;
	private List<String> roles;
}
