package com.cervantes.spring.security.Oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cervantes.*")
public class CervantesSpringSecurityOauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervantesSpringSecurityOauth2ServerApplication.class, args);
	}

}
