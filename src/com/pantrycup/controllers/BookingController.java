package com.pantrycup.controllers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pantrycup.dataproviders.BookingsDBTable;
import com.pantrycup.entities.Bookings;

@Controller
@RequestMapping(value="/")
public class BookingController 
{
    @RequestMapping(value="/startBooking", method = RequestMethod.GET)
    public String tryLogin(ModelMap model) 
    {        
		return "bookservice";
    }
    
    @RequestMapping(value="/doBook", method = RequestMethod.POST)
    public String doLogout(ModelMap model) 
    {  
    	LocalDateTime fromDateTime = null;
    	LocalDateTime toDateTime = null;
    	int totalCost = 0;
    	
    	//Creating a booking object
    	Bookings booking = new Bookings();
    	booking.setBookingDate(LocalDateTime.now());
    	booking.setCustomerUser(null);
    	booking.setFromDateTime(fromDateTime);
    	booking.setToDateTime(toDateTime);
    	booking.setFullDayBooking(false);
    	booking.setTotalCost(totalCost);
    	
    	//Check if he can be booked
    	
    	//Save to DB
    	BookingsDBTable.saveBooking(booking);
    	
		return "serviceprovidersearch";
    }

}
