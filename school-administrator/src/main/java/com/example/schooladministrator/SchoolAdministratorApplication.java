package com.example.schooladministrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SchoolAdministratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAdministratorApplication.class, args);
	}

}
