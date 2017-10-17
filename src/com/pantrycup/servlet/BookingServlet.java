package com.pantrycup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pantrycup.dataproviders.CustomerUserDBTable;
import com.pantrycup.entities.CustomerUser;

public class BookingServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.sendRedirect("serviceprovidersearch.jsp");
	}
}
