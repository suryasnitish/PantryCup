package com.pantrycup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pantrycup.controllers.model.ServiceProviderBookingsModel;
import com.pantrycup.dataproviders.BookingsDBTable;
import com.pantrycup.entities.Bookings;
import com.pantrycup.entities.CustomerUser;
import com.pantrycup.entities.ServiceProviderUser;
import com.pantrycup.spring.beans.session.UserSession;

@RestController
public class CustomerAjaxService
{
	@Autowired
	UserSession userSession;
	
	@RequestMapping(value = "/customer/bookings")
	public String getServiceProvidersViaAjax() 
	{
		BookingsDBTable bookingsTable = new BookingsDBTable();
		
		CustomerUser currentUser = userSession.getCurrentUser();
		List<Bookings> serviceProviderBookingsList = bookingsTable.fetchSpecifiedCustomerBookings(currentUser);

		ServiceProviderBookingsModel serviceProviderBookingsData = new ServiceProviderBookingsModel();
		for (Bookings bookings : serviceProviderBookingsList) 
		{
			serviceProviderBookingsData.getData().add(bookings);
		}

		ObjectMapper mapper = new ObjectMapper();
		String serviceProvidersBookingsListJSONAsString = null;
		try 
		{
			serviceProvidersBookingsListJSONAsString = mapper.writeValueAsString(serviceProviderBookingsData);
		} 
		catch (JsonProcessingException e) 
		{
			e.printStackTrace();
		}
		return serviceProvidersBookingsListJSONAsString;
	}
}

