package com.cervantes.contract.model;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(Include.NON_NULL) 
@JsonPropertyOrder({ "identityProofLinkLocalPC", "addressProofLinkLocalPC" , "adharNumber" })
@JsonDeserialize(builder = CAF.Builder.class)
public class CAF {

	@JsonProperty
	private String identityProofLinkLocalPC;
	
	@JsonProperty
	private String addressProofLinkLocalPC;
	
	@JsonProperty
	private String adharNumber;

	public String getIdentityProofLinkLocalPC() {
		return identityProofLinkLocalPC;
	}
	public void setIdentityProofLinkLocalPC(String identityProofLinkLocalPC) {
		this.identityProofLinkLocalPC = identityProofLinkLocalPC;
	}
	public String getAddressProofLinkLocalPC() {
		return addressProofLinkLocalPC;
	}
	public void setAddressProofLinkLocalPC(String addressProofLinkLocalPC) {
		this.addressProofLinkLocalPC = addressProofLinkLocalPC;
	}
	public String getAdharNumber() {
		return adharNumber;
	}
	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}


	private CAF(Builder builder) {
		this.identityProofLinkLocalPC = builder.identityProofLinkLocalPC;

		this.addressProofLinkLocalPC = builder.addressProofLinkLocalPC;

		this.adharNumber = builder.adharNumber;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder{

		private String identityProofLinkLocalPC;
		private String addressProofLinkLocalPC;	
		private String adharNumber;	

		private Builder() {

		}

		public Builder withidentityProofLinkLocalPC(String identityProofLinkLocalPC) {
			if(StringUtils.isEmpty(identityProofLinkLocalPC)) {
				throw new IllegalArgumentException("identityProof can not be null");
			}
			this.identityProofLinkLocalPC = identityProofLinkLocalPC;
			return this;
		}

		public Builder withaddressProofLinkLocalPC(String addressProofLinkLocalPC) {
			if(StringUtils.isEmpty(addressProofLinkLocalPC)) {
				throw new IllegalArgumentException("Addres proof can not be null");
			}
			this.addressProofLinkLocalPC = addressProofLinkLocalPC;
			return this;
		}

		public Builder withadharNumber(String adharNumber) {
			if(StringUtils.isEmpty(adharNumber)) {
				throw new IllegalArgumentException("adharNumber can not be null");
			}
			this.adharNumber = adharNumber;
			return this;
		}

		public CAF build() {
			return new CAF(this);
		}

	}
}
