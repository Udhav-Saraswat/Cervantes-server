package com.cervantes.spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cervantes.spring.security.entity.User;
import com.cervantes.spring.security.model.GroupUserDetails;
import com.cervantes.spring.security.repository.repository;

@Service
public class GroupUserDetailsService implements UserDetailsService {
	
	@Autowired
	private repository repo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = repo.findByUserName(userName);
		return user.map(GroupUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException(userName + "does not exist in system"));
	}
	
	

}
