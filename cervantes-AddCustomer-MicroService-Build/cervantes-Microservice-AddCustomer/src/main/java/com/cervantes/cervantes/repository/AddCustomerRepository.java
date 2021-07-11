package com.cervantes.cervantes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cervantes.cervantes.entity.Customer;

@Repository
public interface AddCustomerRepository extends CrudRepository<Customer, Long>{
	
}
