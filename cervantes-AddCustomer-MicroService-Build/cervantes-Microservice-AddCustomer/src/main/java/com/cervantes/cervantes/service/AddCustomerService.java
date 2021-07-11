package com.cervantes.cervantes.service;

import java.util.Map;

import com.cervantes.contract.request.AddCustomerAccount;
import com.cervantes.contract.response.AddCustomerResponse;

public interface AddCustomerService {
	
	public AddCustomerResponse addCustomer(AddCustomerAccount customer, Map<String,byte[]> mapImages);

}
