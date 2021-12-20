package com.example.correspondence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CorrespondenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrespondenceApplication.class, args);
	}

}
