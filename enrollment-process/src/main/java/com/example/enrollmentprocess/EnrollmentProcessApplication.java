package com.example.enrollmentprocess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class EnrollmentProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnrollmentProcessApplication.class, args);
	}

}
