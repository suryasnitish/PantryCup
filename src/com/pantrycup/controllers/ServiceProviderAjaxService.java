package com.pantrycup.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pantrycup.dataproviders.ServiceProviderDBTable;
import com.pantrycup.entities.ServiceProviderUser;

@RestController
public class ServiceProviderAjaxService 
{
	@RequestMapping(value = "/search/serviceprovider")
	public String getServiceProvidersViaAjax() 
	{
		ServiceProviderDBTable serviceProviderTable = new ServiceProviderDBTable();
		List<ServiceProviderUser> serviceProviderList = serviceProviderTable.fetchAllServiceProviders();
		JSONObject serviceProviderJSON = new JSONObject(serviceProviderList);
		return serviceProviderJSON.toString();
	}
}
