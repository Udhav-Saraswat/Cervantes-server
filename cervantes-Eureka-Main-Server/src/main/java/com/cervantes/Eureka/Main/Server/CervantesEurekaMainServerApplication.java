package com.cervantes.Eureka.Main.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
public class CervantesEurekaMainServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervantesEurekaMainServerApplication.class, args);
	}

}
