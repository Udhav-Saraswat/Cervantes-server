package com.cervantes.contract.response;

import com.cervantes.contract.model.CustomerName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(Include.NON_NULL) 
@JsonPropertyOrder({ "customerName", "customerProfilePhotoLinkLocalPC" , "mobileNumber" , "streetAddress" ,"cafDetails", "city", "verificationStatus"})
@JsonSerialize
public class AddCustomerResponse {
	
	@JsonProperty
	private CustomerName customerName;
	
	@JsonProperty
	private String userName;
	
	@JsonProperty
	private String passswordEncoded;

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

	public String getPasssword() {
		return passswordEncoded;
	}

	public void setPasssword(String passsword) {
		this.passswordEncoded = passsword;
	}
	
	private AddCustomerResponse(Builder builder) {
		this.customerName = builder.customerName;
		
		this.userName = builder.userName;
		
		this.passswordEncoded = builder.passswordEncoded;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static final class Builder{
		private CustomerName customerName;	
    	private String userName;
		private String passswordEncoded;
		
		private Builder() {
			
		}
		
		public Builder withcustomerName(CustomerName customerName) {
			this.customerName = customerName;
			return this;
		}
		public Builder withUserName(String userName) {
			this.userName = userName;
			return this;
		}
		public Builder withPassswordEncoded(String passswordEncoded) {
			this.passswordEncoded = passswordEncoded;
			return this;
		}
		
		public AddCustomerResponse build() {
			return new AddCustomerResponse(this);
		}
			
	}
	
}
