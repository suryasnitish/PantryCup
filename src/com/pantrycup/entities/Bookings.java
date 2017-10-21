package com.pantrycup.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bookings")
public class Bookings 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long no;
	@ManyToOne
	@JoinColumn
	private ServiceProviderUser serviceProvider;
	@ManyToOne
	@JoinColumn
	private CustomerUser customerUser;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private LocalDateTime bookingDate;
	private double totalCost;
	private boolean isFullDayBooking;
	private String status;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}
	public boolean isFullDayBooking() {
		return isFullDayBooking;
	}
	public void setFullDayBooking(boolean isFullDayBooking) {
		this.isFullDayBooking = isFullDayBooking;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public ServiceProviderUser getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProviderUser serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public CustomerUser getCustomerUser() {
		return customerUser;
	}
	public void setCustomerUser(CustomerUser customerUser) {
		this.customerUser = customerUser;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	
	
	
	

}
