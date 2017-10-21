package com.pantrycup.dataproviders;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pantrycup.constants.BookingStatusConstant;
import com.pantrycup.entities.Bookings;
import com.pantrycup.entities.CustomerUser;
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
	
	public List<Bookings> fetchSpecifiedServiceProviderBookings(ServiceProviderUser serviceProviderUser)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Bookings where serviceprovider_no = ?");
		query.setParameter(0, serviceProviderUser.getNo());
		List<Bookings> serviceProviderBookingsList=query.list();
		session.close();
		return serviceProviderBookingsList; 
		
	}

	public List<Bookings> fetchSpecifiedCustomerBookings(CustomerUser customerUser)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Bookings where customeruser_no = ?");
		query.setParameter(0, customerUser.getNo());
		List<Bookings> allCustomerBookingsList=query.list();
		session.close();
		return allCustomerBookingsList; 
	}

	public void cancelBooking(long bookingNo)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Bookings booking = session.get(Bookings.class, bookingNo);
		booking.setStatus(BookingStatusConstant.CANCELLED);
		transaction.commit();
		session.save(booking);
		session.close();
	}

	public void rejectBooking(long bookingNo)
	{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Bookings booking = session.get(Bookings.class, bookingNo);
		booking.setStatus(BookingStatusConstant.REJECTED);
		transaction.commit();
		session.save(booking);
		session.close();
		
	}

}
