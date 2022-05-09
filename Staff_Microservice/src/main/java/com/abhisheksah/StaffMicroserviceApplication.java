package com.abhisheksah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StaffMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffMicroserviceApplication.class, args);
	}

}
//sonar:sonar -Dsonar.login=734afbe7e7fbd69ba700aa63fc27f5b77ef13996