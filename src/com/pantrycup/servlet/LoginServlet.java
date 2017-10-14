package com.pantrycup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pantrycup.dataproviders.CustomerUserDBTable;
import com.pantrycup.dataproviders.ServiceProviderDBTable;
import com.pantrycup.entities.CustomerUser;

public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		CustomerUserDBTable customerUserTable=new CustomerUserDBTable();
		CustomerUser customeruser = customerUserTable.findByUserName(username);
		if(customeruser!= null && password.equals(customeruser.getPassword()))
		{
			response.sendRedirect("serviceprovidersearch.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}
}
