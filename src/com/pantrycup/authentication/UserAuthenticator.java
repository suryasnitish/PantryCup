package com.pantrycup.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class UserAuthenticator
{
	static List<HttpSession> authenticatedSessionsList = new ArrayList<HttpSession>();
	
	public static void addToAuthenticatedSession(HttpSession session) 
	{
		authenticatedSessionsList.add(session);
	}
	
	/**
	 * This method checks whether the parameter session is 
	 * included in the list of logged-in sessions.
	 * 
	 * @param session
	 * @return
	 */
	public static boolean isAuthenticated(HttpSession session)
	{
		return authenticatedSessionsList.contains(session);
	}

	public static void removeFromAuthenticatedSession(HttpSession session) 
	{
		authenticatedSessionsList.remove(session);
	}



}
