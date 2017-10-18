package com.pantrycup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserCredentials")
public class UserCredentials 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long no;
	
	private String username;
	
	private String password;
	
	@OneToOne
	@JoinColumn(name="no")
	private CustomerUser customerUser;
	
	@OneToOne
	@JoinColumn(name="no")
	private ServiceProviderUser serviceProviderUser;
	

	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerUser getCustomerUser() {
		return customerUser;
	}
	public void setCustomerUser(CustomerUser customerUser) {
		this.customerUser = customerUser;
	}
	
}
