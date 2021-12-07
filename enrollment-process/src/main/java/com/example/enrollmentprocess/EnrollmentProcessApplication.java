package com.example.enrollmentprocess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EnrollmentProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentProcessApplication.class, args);
	}

}
