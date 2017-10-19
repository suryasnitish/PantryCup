package com.pantrycup.dataproviders;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pantrycup.entities.Bookings;
import com.pantrycup.entities.ServiceProviderUser;

public class BookingsDBTable 
{
	private SessionFactory sessionFactory;
	
	public BookingsDBTable()
	{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
	}

	public void saveBooking(Bookings booking) 
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(booking);
		transaction.commit();		
		session.close();
	}

	public List<Bookings> fetchAllServiceProviderBookings()
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Bookings");
		List<Bookings> serviceProviderBookingsList=query.list();
		session.close();
		return serviceProviderBookingsList; 
		
	}

}
