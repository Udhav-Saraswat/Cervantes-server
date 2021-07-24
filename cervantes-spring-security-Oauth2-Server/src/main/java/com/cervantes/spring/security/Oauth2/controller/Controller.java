package com.cervantes.spring.security.Oauth2.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	 @GetMapping("/user/me")
	    public Principal user(Principal principal) {
	        return principal;
	    }
}
