package com.piltover.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.piltover.dto.response.LoadStartAddress;

public interface StartAddressRepository extends JpaRepository<LoadStartAddress, String>{
	@Procedure("CallStartAddress")
	List<LoadStartAddress> CallStartAddress();
}
