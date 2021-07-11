package com.cervantes.contract.request;

import org.apache.commons.lang3.StringUtils;

import com.cervantes.contract.model.CAF;
import com.cervantes.contract.model.CustomerName;
import com.cervantes.enumModel.VerificationStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonInclude(Include.NON_NULL) 
@JsonPropertyOrder({ "customerName", "customerProfilePhotoLinkLocalPC" , "mobileNumber" , "streetAddress" ,"cafDetails", "city", "verificationStatus"})
@JsonDeserialize(builder = AddCustomerAccount.Builder.class)
public class AddCustomerAccount {
	
	@JsonProperty
	private CustomerName customerName;
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private String uuid;
	
	@JsonProperty
	private String customerProfilePhotoLinkLocalPC;
	
	@JsonProperty
	private String mobileNumber;
	
	@JsonProperty
	private String streetAddress;

	@JsonProperty
	private CAF cafDetails;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private VerificationStatus verificationStatus ;
	
	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}
	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
	
	public CustomerName getCustomerName() {
		return customerName;
	}
	public void setCustomerName(CustomerName customerName) {
		this.customerName = customerName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCustomerProfilePhotoLinkLocalPC() {
		return customerProfilePhotoLinkLocalPC;
	}
	public void setCustomerProfilePhotoLinkLocalPC(String customerProfilePhotoLinkLocalPC) {
		this.customerProfilePhotoLinkLocalPC = customerProfilePhotoLinkLocalPC;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public CAF getCafDetails() {
		return cafDetails;
	}
	public void setCafDetails(CAF cafDetails) {
		this.cafDetails = cafDetails;
	}
	
	private AddCustomerAccount(Builder builder) {
		this.customerName = builder.customerName;
		
		this.userName = builder.userName;
		
		this.uuid = builder.uuid;
		

		this.customerProfilePhotoLinkLocalPC = builder.customerProfilePhotoLinkLocalPC ;
		

		this.mobileNumber =  builder.mobileNumber;
		

		this.streetAddress =  builder.streetAddress;


		this.cafDetails = builder.cafDetails;
		

		this.city = builder.city;
		

		this.verificationStatus = builder.verificationStatus ;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static final class Builder{
		private CustomerName customerName;	
    	private String userName;
		private String uuid;
		private String customerProfilePhotoLinkLocalPC;		
		private String mobileNumber;
		private String streetAddress;
     	private CAF cafDetails;
		private String city;
		private VerificationStatus verificationStatus ;
		
		private Builder() {
			
		}
		
		public Builder withcustomerName(CustomerName customerName) {
			if(null == customerName) {
				throw new IllegalArgumentException("Customer Name can not be null");
			}
			this.customerName = customerName;
			return this;
		}
		
		public Builder withUserName(String userName) {
			if(StringUtils.isEmpty(userName)) {
				throw new IllegalArgumentException("User Name can not be null");
			}
			this.userName = userName;
			return this;
		}
		
		public Builder withUuid(String uuid) {
			this.uuid = uuid;
			return this;
		}
		
		public Builder withCustomerProfilePhotoLinkLocalPC(String customerProfilePhotoLinkLocalPC) {
			this.customerProfilePhotoLinkLocalPC = customerProfilePhotoLinkLocalPC;
			return this;
		}
		
		public Builder withMobileNumber(String mobileNumber) {
			if(StringUtils.isEmpty(mobileNumber)) {
				throw new IllegalArgumentException("Mobile Number can not be null");
			}
			this.mobileNumber = mobileNumber;
			return this;
		}
		
		public Builder withStreetAddress(String streetAddress) {
			if(StringUtils.isEmpty(streetAddress)) {
				throw new IllegalArgumentException("Address can not be null");
			}
			this.streetAddress = streetAddress;
			return this;
		}
		
		public Builder withCafDetails(CAF cafDetails) {
			if(null == cafDetails) {
				throw new IllegalArgumentException("Customer Verification Details can not be null");
			}
			this.cafDetails = cafDetails;
			return this;
		}
		
		public Builder withCity(String city) {
			if(StringUtils.isEmpty(city)) {
				throw new IllegalArgumentException("City can not be null");
			}
			this.city = city;
			return this;
		}
		
		public Builder withVerificationStatus(VerificationStatus verificationStatus) {
			this.verificationStatus = verificationStatus;
			return this;
		}
		
		
		public AddCustomerAccount build() {
			return new AddCustomerAccount(this);
		}
	
	}
}
