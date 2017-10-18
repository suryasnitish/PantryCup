package com.pantrycup.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class UserAuthenticator
{
	static List<Session> authenticatedSessionsList = new ArrayList<Session>();
	
	public static boolean isAuthenticated(HttpSession session)
	{
		return authenticatedSessionsList.contains(session);
	}

}
