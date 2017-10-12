package com.pantrycup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pantrycup.dataproviders.ServiceProviderDBTable;

public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServiceProviderDBTable provider=new ServiceProviderDBTable();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + provider.fetchAllServiceProviders() + "</h1>");
	}
}
