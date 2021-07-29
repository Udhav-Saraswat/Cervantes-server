package com.cervantes.spring.security.Oauth2.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class Controller {

	@GetMapping("/principal")
	public Principal user(Principal principal) {
		return principal;
	}
	@GetMapping
	public String stringCheck() {
		return "Yes I'am Working!!";
	}
}
