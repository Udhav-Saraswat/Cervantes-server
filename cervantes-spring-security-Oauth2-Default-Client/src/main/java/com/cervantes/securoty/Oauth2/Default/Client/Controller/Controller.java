package com.cervantes.securoty.Oauth2.Default.Client.Controller;

import java.security.Principal;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
public class Controller {

    @RequestMapping("/securedPage")
    public String securedPage(Model model, Principal principal) {
        return "securedPage";
    }

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        return "index";
    }
    
	@GetMapping("/status")
	public String stringCheck() {
		return "Yes I'am Working!!";
	}
	
}
