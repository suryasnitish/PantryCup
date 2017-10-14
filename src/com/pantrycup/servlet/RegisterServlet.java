package com.pantrycup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pantrycup.dataproviders.CustomerUserDBTable;
import com.pantrycup.dataproviders.ServiceProviderDBTable;
import com.pantrycup.entities.CustomerUser;
import com.pantrycup.entities.ServiceProviderUser;

public class RegisterServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String isServiceProvider = request.getParameter("isserviceprovidercheckbox");
		if (isServiceProvider==null)
		{
			CustomerUser customerUser = new CustomerUser();
			String fullname = request.getParameter("fullname");
			customerUser.setFullname(fullname);
			System.out.println(fullname);
			String username = request.getParameter("username");
			customerUser.setUsername(username);
			System.out.println(username);
			String password = request.getParameter("password");
			customerUser.setPassword(password);
			System.out.println(password);
			String email = request.getParameter("email");
			customerUser.setEmail(email);
			System.out.println(email);
			String location = request.getParameter("location");
			customerUser.setLocation(location);
			System.out.println(location);
			String contactNo = request.getParameter("contactNo");
			customerUser.setContactNo(contactNo);
			System.out.println(contactNo);

			CustomerUserDBTable customerusertable = new CustomerUserDBTable();
			customerusertable.saveCustomerUser(customerUser);
		} else
		{
			ServiceProviderUser serviceProviderUser = new ServiceProviderUser();
			String fullname = request.getParameter("fullname");
			serviceProviderUser.setFullname(fullname);
			System.out.println(fullname);
			String username = request.getParameter("username");
			serviceProviderUser.setUsername(username);
			System.out.println(username);
			String password = request.getParameter("password");
			serviceProviderUser.setPassword(password);
			System.out.println(password);
			String email = request.getParameter("email");
			serviceProviderUser.setEmail(email);
			System.out.println(email);
			String location = request.getParameter("location");
			serviceProviderUser.setLocation(location);
			System.out.println(location);
			String contactNo = request.getParameter("contactNo");
			serviceProviderUser.setContactNo(contactNo);
			System.out.println(contactNo);
			String specialization = request.getParameter("specialization");
			serviceProviderUser.setSpecialization(specialization);
			System.out.println(specialization);
			String costbasissel = request.getParameter("costbasisselect");
			serviceProviderUser.setCostBasis(costbasissel);
			System.out.println(costbasissel);
			String cost = request.getParameter("cost");
			double costvalue = Double.parseDouble(cost);
			serviceProviderUser.setCost(costvalue);
			System.out.println(cost);
			
			
			ServiceProviderDBTable serviceProviderTable = new ServiceProviderDBTable();
			serviceProviderTable.saveServiceProvider(serviceProviderUser);
		}
		response.sendRedirect("serviceprovidersearch.jsp");

	}
}
