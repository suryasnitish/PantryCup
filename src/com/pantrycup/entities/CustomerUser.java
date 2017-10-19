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
@Table(name="CustomerUser")
public class CustomerUser
{
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="userCredentials")})
	private long no;
	
	@OneToOne(targetEntity=UserCredentials.class,mappedBy="customerUser")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private UserCredentials userCredentials;
	
    @OneToMany(mappedBy="customerUser")
    @JsonIgnore
    List<Bookings> bookings;
	
	private String email;
	
	private String contactNo;
	
	private String fullname;
	
	private String location;
	

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
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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
