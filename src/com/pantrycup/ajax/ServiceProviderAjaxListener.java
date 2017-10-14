package com.pantrycup.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderAjaxListener
{
	@ResponseBody
	@RequestMapping(value = "/search/allproviders")
	public AjaxResponseBody getSearchResultViaAjax() {

		AjaxResponseBody result = new AjaxResponseBody();
		//logic
		return result;
	}
}
