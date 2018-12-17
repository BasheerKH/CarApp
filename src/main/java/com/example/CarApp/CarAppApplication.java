package com.example.CarApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CarAppApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(CarAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
		
		logger.info("Hello Spring Boot");
	}

}

