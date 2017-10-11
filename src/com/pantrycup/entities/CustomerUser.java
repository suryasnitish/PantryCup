package com.pantrycup.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustomerUser")
public class CustomerUser
{
	@Id
	private long userNo;
	private String username;
	private String password; 
	private String fullname;
	private String location;
	public long getUserNo()
	{
		return userNo;
	}
	public void setUserNo(long userNo)
	{
		this.userNo = userNo;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getFullname()
	{
		return fullname;
	}
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	
}
