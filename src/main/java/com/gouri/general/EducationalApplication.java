package com.gouri.general;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EducationalApplication {

	private static final Logger log = LoggerFactory.getLogger(EducationalApplication.class);

	public static void main(String[] args) {

		log.info("Starting EducationalApplication");
		SpringApplication.run(EducationalApplication.class, args);
	}

}
