package com.piltover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.piltover")
public class DatnPiltoverTravelBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatnPiltoverTravelBeApplication.class, args);
	}

}
