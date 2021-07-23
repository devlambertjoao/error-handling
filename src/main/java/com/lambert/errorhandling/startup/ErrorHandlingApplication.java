package com.lambert.errorhandling.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lambert.errorhandling.*")
public class ErrorHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorHandlingApplication.class, args);
	}

}
