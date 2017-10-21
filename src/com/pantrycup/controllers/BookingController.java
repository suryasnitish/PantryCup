package com.pantrycup.controllers;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pantrycup.constants.BookingStatusConstant;
import com.pantrycup.dataproviders.BookingsDBTable;
import com.pantrycup.dataproviders.ServiceProviderDBTable;
import com.pantrycup.entities.Bookings;
import com.pantrycup.entities.ServiceProviderUser;
import com.pantrycup.spring.beans.session.UserSession;

@Controller
@RequestMapping(value = "/")
public class BookingController
{
	@Autowired
	UserSession currentSession;

	@RequestMapping(value = "/startBooking", method = RequestMethod.GET)
	public String tryLogin(ModelMap model)
	{
		return "bookservice";
	}

	@RequestMapping(value = "/doBook", method = RequestMethod.POST)
	public String doLogout(HttpServletRequest request, @RequestParam Map<String, String> allRequestParams,
			ModelMap model)
	{
		String fromDateTimeRange = allRequestParams.get("fromdatetimerange");
		String providerNo = allRequestParams.get("providerno");

		String[] parts = fromDateTimeRange.split("-", 2);
		String fromDate = parts[0].trim();
		String toDate = parts[1].trim();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
		LocalDateTime fromDateTime = LocalDateTime.parse(fromDate, formatter);
		LocalDateTime toDateTime = LocalDateTime.parse(toDate, formatter);

		ServiceProviderDBTable serviceProviderDBTable = new ServiceProviderDBTable();
		ServiceProviderUser serviceProviderUser = serviceProviderDBTable
				.getServiceProviderByNo(Long.parseLong(providerNo));

		double totalCost = calculateCost(serviceProviderUser, fromDateTime, toDateTime);		

		// Creating a booking object
		Bookings booking = new Bookings();
		booking.setBookingDate(LocalDateTime.now());
		booking.setCustomerUser(currentSession.getCurrentUser());
		booking.setServiceProvider(serviceProviderUser);
		booking.setFromDateTime(fromDateTime);
		booking.setToDateTime(toDateTime);
		booking.setFullDayBooking(false);
		booking.setTotalCost(totalCost);
		booking.setStatus(BookingStatusConstant.BOOKED);

		// Check if he can be booked

		// Save to DB
		BookingsDBTable bookingTable = new BookingsDBTable();
		bookingTable.saveBooking(booking);

		return "serviceprovidersearch";
	}

	private double calculateCost(ServiceProviderUser serviceProviderUser, LocalDateTime fromDateTime,
			LocalDateTime toDateTime)
	{
		double cost = serviceProviderUser.getCost();
		long period = 0;
		
		switch (serviceProviderUser.getCostBasis())
		{
		case "Per Day basis":
			period = ChronoUnit.DAYS.between(fromDateTime, toDateTime);
			break;
		case "Per Hour basis":
			period = ChronoUnit.HOURS.between(fromDateTime, toDateTime);
			break;
		case "Half day basis":
			period = ChronoUnit.HALF_DAYS.between(fromDateTime, toDateTime);
			break;
		}
		return cost*period;

	}

	@RequestMapping(value = "/cancelbooking", method = RequestMethod.POST)
	public String cancelBooking(HttpServletRequest request, @RequestParam Map<String, String> allRequestParams,
			ModelMap model)
	{
		long bookingNo = Long.parseLong(allRequestParams.get("no"));

		BookingsDBTable bookingTable = new BookingsDBTable();
		bookingTable.cancelBooking(bookingNo);
		return null;
	}

	@RequestMapping(value = "/rejectbooking", method = RequestMethod.POST)
	public String rejectBooking(HttpServletRequest request, @RequestParam Map<String, String> allRequestParams,
			ModelMap model)
	{
		long bookingNo = Long.parseLong(allRequestParams.get("no"));

		BookingsDBTable bookingTable = new BookingsDBTable();
		bookingTable.rejectBooking(bookingNo);
		return null;
	}
}
