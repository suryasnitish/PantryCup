package com.pantrycup.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pantrycup.authentication.UserAuthenticator;
import com.pantrycup.dataproviders.CustomerUserDBTable;
import com.pantrycup.entities.CustomerUser;

@Controller
@RequestMapping(value="/")
public class LoginController 
{
    @RequestMapping(value="/doLogin", method = RequestMethod.POST)
    public String tryLogin(HttpServletRequest request,@RequestParam Map<String,String> allRequestParams, ModelMap model) 
    {        
		String username = allRequestParams.get("username");
		String password = allRequestParams.get("password");
				
		CustomerUserDBTable customerUserTable=new CustomerUserDBTable();
		CustomerUser customeruser = customerUserTable.findByUserName(username);
		if(customeruser!= null && password.equals(customeruser.getPassword()))
		{
			UserAuthenticator.addToAuthenticatedSession(request.getSession());
			return "serviceprovidersearch";
		}
		else
		{
			model.addAttribute("errors", "Wrong username or password, please try again");
			return "login";
		}
    }

}
