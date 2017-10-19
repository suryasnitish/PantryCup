package com.pantrycup.controllers.model;

import java.util.ArrayList;
import java.util.List;

import com.pantrycup.entities.Bookings;
import com.pantrycup.entities.ServiceProviderUser;

public class ServiceProviderBookingsModel 
{
		List<Bookings> data = new ArrayList<>();

		public List<Bookings> getData()
		{
			return data;
		}

		public void setData(List<Bookings> data)
		{
			this.data = data;
		}
		
		
}