package com.cervantes.spring.security.Oauth2.Server.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Value("udhav")
//	private String username;
//
//	@Value("saraswat")
//	private String password;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers()
		.antMatchers("/login", "/oauth/authorize")
		.and()
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("udhav")
		.password("saraswat")
//		.password(passwordEncoder().encode("saraswat"))
		.roles("USER");
	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}