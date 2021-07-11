package com.cervantes.cervantes.dao.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.cervantes.cervantes.constant.Constants;
import com.cervantes.cervantes.dao.AddCustomerDao;
import com.cervantes.cervantes.entity.Customer;
import com.cervantes.contract.model.CAF;

@Repository
public class AddCustomerDaoImpl implements AddCustomerDao{
	
	@Value("${info.root}")
	String rootDirectory;

	@Override
	public String saveProfilePhoto(Customer customerEntity,  Map<String,byte[]> mapImages) {
		
		List<String> str = new ArrayList<>();
		
		String userName = customerEntity.getUserName();
		String pathRoot = rootDirectory + "/src/main/resources/" + userName;
		
		File theDir = new File(pathRoot);
		if (!theDir.exists()){
		    theDir.mkdirs();
		}
		
		for (Map.Entry<String,byte[]> mapElement : mapImages.entrySet()) {

			Path path = Paths.get(pathRoot + "/" + userName + "-" + mapElement.getKey() + ".jpg");
			try {
				Files.write(path, mapElement.getValue());
			} catch (IOException e) {
				e.printStackTrace();
			}
			str.add(pathRoot);
		}
		
		customerEntity.setCustomerProfilePhotoLinkLocalPC(str.get(0));
//		CAF caf = CAF.builder().withidentityProofLinkLocalPC(str.get(1)).withaddressProofLinkLocalPC(str.get(2))
//				  .withaddressProofLinkLocalPC(pathRoot).withadharNumber(pathRoot).build();
//		customerEntity.setCafDetails(caf);

		
		return Constants.SAVED_SUCCESS;
	}

}
