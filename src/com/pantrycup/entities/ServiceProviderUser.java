package com.pantrycup.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ServiceProviderUser")
public class ServiceProviderUser  
{
	@Id
	private long no;
	private String username;
	private String password; 
	private String fullname;
	private String specialization;
    private String schedule;
    private double cost;
    private String costBasis;
	public long getNo()
	{
		return no;
	}
	public void setNo(long no)
	{
		this.no = no;
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
	public String getSpecialization()
	{
		return specialization;
	}
	public void setSpecialization(String specialization)
	{
		this.specialization = specialization;
	}
	public String getSchedule()
	{
		return schedule;
	}
	public void setSchedule(String schedule)
	{
		this.schedule = schedule;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	public String getCostBasis()
	{
		return costBasis;
	}
	public void setCostBasis(String costBasis)
	{
		this.costBasis = costBasis;
	}
    
    
}
