
package com.pantrycup.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pantrycup.controllers.model.ServiceProviderBookingsModel;
import com.pantrycup.controllers.model.ServiceProviderViewModel;
import com.pantrycup.dataproviders.BookingsDBTable;
import com.pantrycup.entities.Bookings;
import com.pantrycup.entities.ServiceProviderUser;

@RestController
public class BookingsAjaxService 
{
	@RequestMapping(value = "/search/bookings")
	public String getServiceProvidersViaAjax() 
	{
		BookingsDBTable bookingsTable = new BookingsDBTable();
		List<Bookings> serviceProviderBookingsList = bookingsTable.fetchAllServiceProviderBookings();

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