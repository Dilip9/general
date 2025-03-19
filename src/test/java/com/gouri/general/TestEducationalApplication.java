package com.gouri.general;

import org.springframework.boot.SpringApplication;

public class TestEducationalApplication {

	public static void main(String[] args) {
		SpringApplication.from(EducationalApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
