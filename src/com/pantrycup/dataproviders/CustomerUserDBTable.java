package com.pantrycup.dataproviders;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pantrycup.entities.CustomerUser;
import com.pantrycup.entities.ServiceProviderUser;

public class CustomerUserDBTable
{
private SessionFactory sessionFactory;
	
	public CustomerUserDBTable()
	{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	
	public void saveCustomerUser(CustomerUser customeruser)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(customeruser);
		transaction.commit();
	}

	public CustomerUser findByUserName(String username)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql = "FROM CustomerUser WHERE username = '"+username+"'";
		System.out.println(hql);
		Query query = session.createQuery(hql);
		List<CustomerUser> results = query.list();
		if(results.size()==0)
		{
			return null;
		}
		else
		{
			return results.get(0);
		}
	}
}
