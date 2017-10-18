package com.pantrycup.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pantrycup.authentication.UserAuthenticator;

public class AuthenticationFilter implements Filter
{

	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException
	{
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String uri = httpRequest.getRequestURI();
		if(uri.equals("/PantryCup/login.jsp")||uri.equals("/PantryCup/doLogin"))
		{
			;
		}
		else if(uri.equals("/PantryCup/registeruser.jsp")||uri.equals("/PantryCup/doSignup"))
		{
			;
		}
		else
		{
			if(!UserAuthenticator.isAuthenticated(httpRequest.getSession()))
			{
				httpResponse.sendRedirect("/PantryCup/login.jsp");
				return;
			}
		}
		filterChain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub
		
	}
	
}
