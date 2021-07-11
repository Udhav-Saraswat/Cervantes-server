package com.cervantes.cervantes.dao;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cervantes.cervantes.entity.Customer;

public interface AddCustomerDao {

	
	public String saveProfilePhoto(Customer customerEntity,  Map<String,byte[]> mapImages);
	
}
