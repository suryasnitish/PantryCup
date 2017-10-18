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
import com.pantrycup.entities.UserCredentials;

public class RegisterServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String isServiceProvider = request.getParameter("isserviceprovidercheckbox");
		
		UserCredentials userCredentials = new UserCredentials();
		String username = request.getParameter("username");
		userCredentials.setUsername(username);
		String password = request.getParameter("password");
		userCredentials.setPassword(password);
		
		if (isServiceProvider==null)
		{
			CustomerUser customerUser = new CustomerUser();
			userCredentials.setCustomerUser(customerUser);
			customerUser.setUserCredentials(userCredentials);
			String fullname = request.getParameter("fullname");
			customerUser.setFullname(fullname);
			System.out.println(fullname);
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
			serviceProviderUser.setUserCredentials(userCredentials);
			String fullname = request.getParameter("fullname");
			serviceProviderUser.setFullname(fullname);
			System.out.println(fullname);
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
