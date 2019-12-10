package com.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Integer phoneNum;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="userId", referencedColumnName = "accountId")
	private Account account;
	
	
	

	public Integer getUserId() {
		return userId;
	}




	public void setUserId(Integer userId) {
		this.userId = userId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Integer getPhoneNum() {
		return phoneNum;
	}




	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}




	public Account getAccount() {
		return account;
	}




	public void setAccount(Account account) {
		this.account = account;
	}




	@Override
	public String toString() {
		return "User [account=" + account + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNum=" + phoneNum + ", userId=" + userId + "]";
	}
	
 
	

}
