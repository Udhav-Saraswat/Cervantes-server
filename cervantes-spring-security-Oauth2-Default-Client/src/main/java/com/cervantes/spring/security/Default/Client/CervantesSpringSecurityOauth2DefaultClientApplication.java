package com.cervantes.spring.security.Default.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cervantes.*")
public class CervantesSpringSecurityOauth2DefaultClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervantesSpringSecurityOauth2DefaultClientApplication.class, args);
	}

}
