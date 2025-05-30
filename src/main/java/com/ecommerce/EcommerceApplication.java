package com.ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	static Logger logger = LoggerFactory.getLogger(EcommerceApplication.class);


	public static void main(String[] args) {
		logger.info("Application started");
		SpringApplication.run(EcommerceApplication.class, args);
		logger.info("Application ended");
	}

}
