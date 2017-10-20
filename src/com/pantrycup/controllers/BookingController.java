package com.pantrycup.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pantrycup.dataproviders.BookingsDBTable;
import com.pantrycup.entities.Bookings;
import com.pantrycup.spring.beans.session.UserSession;

@Controller
@RequestMapping(value="/")
public class BookingController 
{
	@Autowired
	UserSession currentSession;
	
    @RequestMapping(value="/startBooking", method = RequestMethod.GET)
    public String tryLogin(ModelMap model) 
    {        
		return "bookservice";
    }
    
    @RequestMapping(value="/doBook", method = RequestMethod.POST)
    public String doLogout(HttpServletRequest request,@RequestParam Map<String,String> allRequestParams, ModelMap model) 
    {  
    	String fromDateTimeRange = allRequestParams.get("fromdatetimerange");
    	
    	String[] parts = fromDateTimeRange.split("-", 2);
    	String fromDate = parts[0].trim();
    	String toDate = parts[1].trim();
    	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
    	LocalDateTime fromDateTime = LocalDateTime.parse(fromDate, formatter);
    	LocalDateTime toDateTime = LocalDateTime.parse(toDate, formatter);
    	
    	int totalCost = 0;
    	
    	//Creating a booking object
    	Bookings booking = new Bookings();
    	booking.setBookingDate(LocalDateTime.now());
    	booking.setCustomerUser(currentSession.getCurrentUser());
    	booking.setFromDateTime(fromDateTime);
    	booking.setToDateTime(toDateTime);
    	booking.setFullDayBooking(false);
    	booking.setTotalCost(totalCost);
    	
    	//Check if he can be booked
    	
    	//Save to DB
    	BookingsDBTable bookingTable = new BookingsDBTable();
    	bookingTable.saveBooking(booking);
    	
		return "serviceprovidersearch";
    }

}
