package com.cervantes.spring.security.Oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SuppressWarnings("deprecation")
@SpringBootApplication
@EnableResourceServer
public class CervantesSpringSecurityOauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervantesSpringSecurityOauth2ServerApplication.class, args);
	}

}
