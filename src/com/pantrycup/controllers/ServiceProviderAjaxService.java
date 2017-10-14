package com.pantrycup.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderAjaxService 
{
	@RequestMapping(value = "/search/serviceprovider")
	public String getServiceProvidersViaAjax() 
	{
		return "welcome";
	}
}
