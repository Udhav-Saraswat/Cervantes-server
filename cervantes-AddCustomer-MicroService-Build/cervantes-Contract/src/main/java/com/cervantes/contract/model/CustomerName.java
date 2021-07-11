package com.cervantes.contract.model;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(Include.NON_NULL) 
@JsonPropertyOrder({ "cutomerFirstName","customerMiddleName","customerLastName"})
@JsonDeserialize(builder = CustomerName.Builder.class)
public class CustomerName {

	@JsonProperty
	private String cutomerFirstName;
	@JsonProperty
	private String customerMiddleName;
	@JsonProperty
	private String customerLastName;
	
	public String getCutomerFirstName() {
		return cutomerFirstName;
	}
	public void setCutomerFirstName(String cutomerFirstName) {
		this.cutomerFirstName = cutomerFirstName;
	}
	public String getCustomerMiddleName() {
		return customerMiddleName;
	}
	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	
	private CustomerName(Builder builder) {
		this.cutomerFirstName = builder.cutomerFirstName;
		this.customerMiddleName = builder.customerMiddleName;
		this.customerLastName = builder.customerLastName;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static final class Builder{

		private String cutomerFirstName;
		private String customerMiddleName;
		private String customerLastName;
		
		private Builder() {
			
		}
		
		public Builder withCutomerFirstName(String cutomerFirstName) {
			if(StringUtils.isEmpty(cutomerFirstName)) {
				throw new IllegalArgumentException("Customer Name can not be null");
			}
			this.cutomerFirstName = cutomerFirstName;
			return this;
		}
		
		public Builder withCustomerMiddleName(String customerMiddleName) {
			this.customerMiddleName = customerMiddleName;
			return this;
		}
		
		public Builder withCustomerLastName(String customerLastName) {
			this.customerLastName = customerLastName;
			return this;
		}
		
		public CustomerName build() {
			return new CustomerName(this);
		}
	}
}
