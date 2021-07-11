package com.cervantes.cervantes.util;

import org.springframework.stereotype.Component;

import com.cervantes.contract.model.CustomerName;
import com.cervantes.contract.request.AddCustomerAccount;

@Component
public class CommonUtil {

	public static String generateUuids(String userName) {
	
		return userName + Math.random();
	}

	public String genrateUserName(CustomerName customerName, String mobileNumber) {
		
		
		return "udhav" + "." + mobileNumber;
	}

	public String genratePassword(AddCustomerAccount customer) {
		
		return "xyz123@123";
	}

}
