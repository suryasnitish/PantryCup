package com.pantrycup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pantrycup.dataproviders.CustomerUserDBTable;
import com.pantrycup.entities.CustomerUser;

public class RegisterServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CustomerUser customeruser=new CustomerUser();
		String fullname=request.getParameter("fullname");
		customeruser.setFullname(fullname);
		System.out.println(fullname);
		String username=request.getParameter("username");
		customeruser.setUsername(username);
		System.out.println(username);
		String password=request.getParameter("password");
		customeruser.setPassword(password);
		System.out.println(password);
		String email=request.getParameter("email");
		customeruser.setEmail(email);
		System.out.println(email);
		String location=request.getParameter("location");
		customeruser.setLocation(location);
		System.out.println(location);
		String contactNo=request.getParameter("contactNo");
		customeruser.setContactNo(contactNo);
		System.out.println(contactNo);
		
		CustomerUserDBTable customerusertable=new CustomerUserDBTable();
		customerusertable.saveCustomerUser(customeruser);
		
		response.sendRedirect("serviceprovidersearch.jsp");
		
	}
}
