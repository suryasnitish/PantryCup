package com.pantrycup.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pantrycup.controllers.model.ServiceProviderViewModel;
import com.pantrycup.dataproviders.ServiceProviderDBTable;
import com.pantrycup.entities.ServiceProviderUser;

@RestController
public class ServiceProviderAjaxService {
	@RequestMapping(value = "/search/serviceprovider")
	public String getServiceProvidersViaAjax() {
		ServiceProviderDBTable serviceProviderTable = new ServiceProviderDBTable();
		List<ServiceProviderUser> serviceProviderList = serviceProviderTable.fetchAllServiceProviders();

		ServiceProviderViewModel serviceProviderData = new ServiceProviderViewModel();
		for (ServiceProviderUser serviceProvider : serviceProviderList) {
			serviceProviderData.getData().add(serviceProvider);
		}

		String serviceProviderGSON = new Gson().toJson(serviceProviderData);
		return serviceProviderGSON;
	}
}
