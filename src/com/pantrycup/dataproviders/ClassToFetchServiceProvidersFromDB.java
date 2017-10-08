package com.pantrycup.dataproviders;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pantrycup.entities.ServiceProvider;

public class ClassToFetchServiceProvidersFromDB
{
	private SessionFactory sessionFactory;
	
	public ClassToFetchServiceProvidersFromDB()
	{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public List<ServiceProvider> fetchAllServiceProviders()
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from ServiceProvider");
		List<ServiceProvider> serviceProviderList=query.list();
		return serviceProviderList; 
	}
}
