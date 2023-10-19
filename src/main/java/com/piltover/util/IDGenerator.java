package com.piltover.util;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.piltover.service.AccountService;

@Component
public class IDGenerator {
	@Autowired
	AccountService accountService;
	 public Long generateRandomNumbers() {
	        Random random = new Random();
	        long min = 1000000000L; // 10 tỷ
	        long max = 9999999999L; // 99 tỷ
	        long range = max - min + 1;
	        long randomNumber = (long) (random.nextDouble() * range) + min;
	        if (accountService.isIDExists(randomNumber)) {
				this.generateRandomNumbers();
			}
	        return Long.valueOf(randomNumber);
	 }
}
