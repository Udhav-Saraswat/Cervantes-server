package com.cervantes.cervantes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cervantes.cervantes.service.AddCustomerService;
import com.cervantes.cervantes.util.ControllerUtil;
import com.cervantes.contract.request.AddCustomerAccount;
import com.cervantes.contract.response.AddCustomerResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin
@RestController
@RequestMapping("CustomerCervantesAPI")
public class CervantesControllerAddCustomer {

	
	@Autowired
	private AddCustomerService addCustomerService;
	
	private static Logger logger = LogManager.getLogger(CervantesControllerAddCustomer.class.getName());
	
	@PostMapping(value = "AddCustomer", consumes = { "multipart/form-data" })
	public ResponseEntity<AddCustomerResponse> authenticateCustomer(
//			@RequestBody AddCustomerAccount customer,
			@RequestParam("userProfilePhoto") MultipartFile userProfilePhoto,
			@RequestParam("userIdentityProof") MultipartFile userIdentityProof,
			@RequestParam("userAddressProof") MultipartFile userAddressProof
			) throws Exception {

		logger.info("In | Started | AddCustomer Controller");
		
		byte[] userProfilePhotoByteArr = userProfilePhoto.getBytes();
		byte[] userIdentityProofByteArr = userIdentityProof.getBytes();
		byte[] userAddressProofByteArr = userAddressProof.getBytes();
		
		
		Map<String,byte[]> mapImages = ControllerUtil.getMapImages(userProfilePhotoByteArr,userIdentityProofByteArr,userAddressProofByteArr);
		
		AddCustomerAccount customer =  AddCustomerAccount.builder().withStreetAddress("abcd").build();
		AddCustomerResponse response = addCustomerService.addCustomer(customer,mapImages);
		
		
		return new ResponseEntity<AddCustomerResponse>(response,HttpStatus.CREATED);
		
		
	}
	
	
}
