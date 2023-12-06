package com.piltover.dto.response;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class LoadStartAddress {
	@Id
	private String start_address;
}
