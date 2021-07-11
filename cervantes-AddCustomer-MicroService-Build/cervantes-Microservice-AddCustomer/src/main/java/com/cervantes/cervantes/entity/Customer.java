package com.cervantes.cervantes.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.cervantes.contract.model.CAF;
import com.cervantes.enumModel.VerificationStatus;

@Component
@Entity
@Table(name="customer_cervantes")
public class Customer {

	@Id
	@Column(name="cutomer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="modified_date")
	private LocalDateTime modifiedDate;
	
	@Column(name="customer_name", columnDefinition = "JSON")
	private String customerName;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="uuid")
	private String uuid;
	
	@Column(name="customer_profile_photo")
	private String customerProfilePhotoLinkLocalPC;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="street_address")
	private String streetAddress;

	@Column(name="caf_details", columnDefinition = "JSON")
	private String cafDetails;
	
	@Column(name="city")
	private String city;
	
	@Column(name="verification_status")
	@Enumerated(EnumType.STRING)
	private VerificationStatus verificationStatus;
	
	public Customer(Integer customerId, LocalDateTime createdDate, LocalDateTime modifiedDate, String customerName,
			String userName, String uuid, String customerProfilePhotoLinkLocalPC, String mobileNumber,
			String streetAddress, String cafDetails, String city, VerificationStatus verificationStatus) {
		super();
		this.customerId = customerId;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.customerName = customerName;
		this.userName = userName;
		this.uuid = uuid;
		this.customerProfilePhotoLinkLocalPC = customerProfilePhotoLinkLocalPC;
		this.mobileNumber = mobileNumber;
		this.streetAddress = streetAddress;
		this.cafDetails = cafDetails;
		this.city = city;
		this.verificationStatus = verificationStatus;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
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

	public String getCafDetails() {
		return cafDetails;
	}

	public void setCafDetails(String cafDetails) {
		this.cafDetails = cafDetails;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", customerName=" + customerName + ", userName=" + userName + ", uuid=" + uuid
				+ ", customerProfilePhotoLinkLocalPC=" + customerProfilePhotoLinkLocalPC + ", mobileNumber="
				+ mobileNumber + ", streetAddress=" + streetAddress + ", cafDetails=" + cafDetails + ", city=" + city
				+ ", verificationStatus=" + verificationStatus + "]";
	}
	
	
}
