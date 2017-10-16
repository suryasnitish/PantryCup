package com.pantrycup.controllers.model;

import java.util.ArrayList;
import java.util.List;

import com.pantrycup.entities.ServiceProviderUser;

public class ServiceProviderViewModel 
{
		List<ServiceProviderUser> data = new ArrayList<>();

		public List<ServiceProviderUser> getData() 
		{
			return data;
		}

		public void setData(List<ServiceProviderUser> data) 
		{
			this.data = data;
		}			
}
