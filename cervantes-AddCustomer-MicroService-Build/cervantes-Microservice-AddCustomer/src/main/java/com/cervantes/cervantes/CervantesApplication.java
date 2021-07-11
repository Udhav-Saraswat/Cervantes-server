package com.cervantes.cervantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cervantes.*")
@EnableEurekaClient
public class CervantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervantesApplication.class, args);
	}

}
