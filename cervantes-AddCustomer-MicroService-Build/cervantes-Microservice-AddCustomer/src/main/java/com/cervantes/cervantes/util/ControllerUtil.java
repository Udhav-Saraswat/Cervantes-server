package com.cervantes.cervantes.util;

import java.util.HashMap;
import java.util.Map;

public class ControllerUtil {
	
	
	public static Map<String,byte[]> getMapImages(byte[] userProfilePhotoByteArr, byte[] userIdentityProofByteArr, byte[] userAddressProofByteArr) {
		Map<String,byte[]> mapImages = new HashMap<>();
		mapImages.put("AdharCard", userProfilePhotoByteArr);
		mapImages.put("IdentityProof", userIdentityProofByteArr);
		mapImages.put("AddressProof", userAddressProofByteArr);
		
		return mapImages;
	}

}
