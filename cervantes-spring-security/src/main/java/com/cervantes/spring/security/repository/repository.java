package com.cervantes.spring.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cervantes.spring.security.entity.User;

@Repository
public interface repository extends JpaRepository<User, Integer>  {
	
	Optional<User> findByUserName(String userName);

}
