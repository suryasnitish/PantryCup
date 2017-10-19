package com.pantrycup.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ServiceProviderUser")
public class ServiceProviderUser  
{
	@Id
	@GeneratedValue(generator="gen2")
	@GenericGenerator(name="gen2", strategy="foreign", parameters={@Parameter(name="property", value="userCredentials")})
	private long no;
	
	@OneToOne(targetEntity=UserCredentials.class,mappedBy="serviceProviderUser")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private UserCredentials userCredentials;
	
    @OneToMany(mappedBy="serviceProvider")
    @JsonIgnore
    List<Bookings> bookings;
	
	private String fullname;
	
	private String specialization;
	
    private double cost;
    
    private String costBasis;
    
    private String contactNo;
    
    private String location;
    
    private String email;
    
	public long getNo()
	{
		return no;
	}
	public void setNo(long no)
	{
		this.no = no;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserCredentials getUserCredentials() {
		return userCredentials;
	}
	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}
	public List<Bookings> getBookings() {
		return bookings;
	}
	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}
	
    
    
}
