package com.pantrycup.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pantrycup.entities.CustomerUser;

@Component
@Scope(value="session")
public class UserSession
{
	CustomerUser currentUser;
}
