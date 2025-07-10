package com.kerro.AvalonManagementBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvalonManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvalonManagementBackendApplication.class, args);
		System.out.println("Database URL: " + System.getenv("SPRING_DATASOURCE_URL"));
	}
}
