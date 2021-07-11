package com.cervantes.cervantes.service.impl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cervantes.cervantes.controller.CervantesControllerAddCustomer;
import com.cervantes.cervantes.dao.AddCustomerDao;
import com.cervantes.cervantes.entity.Customer;
import com.cervantes.cervantes.repository.AddCustomerRepository;
import com.cervantes.cervantes.service.AddCustomerService;
import com.cervantes.cervantes.util.CommonUtil;
import com.cervantes.contract.request.AddCustomerAccount;
import com.cervantes.contract.response.AddCustomerResponse;
import com.cervantes.enumModel.VerificationStatus;

@Service
public class AddCustomerServiceImpl implements AddCustomerService {

	@Autowired
	private Customer customerEntity;
	
	@Autowired
	AddCustomerDao addCustomerDao;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private AddCustomerRepository repo;
	
	private static Logger logger = LogManager.getLogger(AddCustomerServiceImpl.class.getName());
	
	@Override
	public AddCustomerResponse addCustomer(AddCustomerAccount customer, Map<String,byte[]> mapImages) {
		
		customerEntity = new Customer();
		
		String userName =  commonUtil.genrateUserName(customer.getCustomerName(),customer.getMobileNumber());
		
		customerEntity.setUserName(customer.getUserName());
		customerEntity.setUuid(CommonUtil.generateUuids(customer.getUserName()));
		customerEntity.setMobileNumber(customer.getMobileNumber());
//		customerEntity.setCustomerName(customer.getCustomerName().toString());
//		customerEntity.setCafDetails(customer.getCafDetails());
		customerEntity.setCity(customer.getCity());
		customerEntity.setCreatedDate(LocalDateTime.now());
		
		customerEntity.setModifiedDate(null);
		customerEntity.setStreetAddress(customer.getStreetAddress());
		customerEntity.setUserName(userName);
//		customerEntity.setVerificationStatus(VerificationStatus.IN_PROGRESS);
		
		if(customer.getCustomerProfilePhotoLinkLocalPC() != null || StringUtils.isNoneEmpty(customer.getCustomerProfilePhotoLinkLocalPC())) {
		
		}
		
		addCustomerDao.saveProfilePhoto(customerEntity, mapImages);
		
		
		String password = commonUtil.genratePassword(customer);
		
		repo.save(customerEntity);
		
		return AddCustomerResponse.builder().withcustomerName(customer.getCustomerName()).withUserName(userName).withPassswordEncoded(password).build();
	}

}
