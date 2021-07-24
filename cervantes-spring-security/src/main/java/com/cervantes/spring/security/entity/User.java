package com.cervantes.spring.security.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USER_AUTH")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	private String passowrd;
	private boolean acitve;

	private String roles;

	public Long getId() {
		return id;
	}
	public User(Long id, String userName, String passowrd, boolean acitve, String roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.passowrd = passowrd;
		this.acitve = acitve;
		this.roles = roles;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getuserName() {
		return userName;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public boolean isAcitve() {
		return acitve;
	}
	public void setAcitve(boolean acitve) {
		this.acitve = acitve;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passowrd=" + passowrd + ", acitve=" + acitve + ", roles="
				+ roles + "]";
	}

}
