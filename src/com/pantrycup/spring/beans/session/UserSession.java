package com.pantrycup.spring.beans.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

import com.pantrycup.entities.CustomerUser;
import com.pantrycup.entities.ServiceProviderUser;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession
{
	private CustomerUser currentUser;
	private ServiceProviderUser currentServiceProvider;

	public CustomerUser getCurrentUser()
	{
		return currentUser;
	}

	public void setCurrentUser(CustomerUser currentUser)
	{
		this.currentUser = currentUser;
	}

	public ServiceProviderUser getCurrentServiceProvider()
	{
		return currentServiceProvider;
	}

	public void setCurrentServiceProvider(ServiceProviderUser currentServiceProvider)
	{
		this.currentServiceProvider = currentServiceProvider;
	}	
	
	
}
