package com.pantrycup.spring.beans.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pantrycup.entities.CustomerUser;

@Component
@Scope(value="session")
public class UserSession
{
	private CustomerUser currentUser;

	public CustomerUser getCurrentUser()
	{
		return currentUser;
	}

	public void setCurrentUser(CustomerUser currentUser)
	{
		this.currentUser = currentUser;
	}	
	
	
}
