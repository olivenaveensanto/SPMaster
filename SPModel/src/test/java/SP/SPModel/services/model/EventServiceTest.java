package SP.SPModel.services.model;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import SP.SPModel.util.HibernateUtil;

public class EventServiceTest {

	@Test
	public void testCreateEvent() {
		EventService eTest = 
				new EventService();
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		eTest.setSessionFactory(HibernateUtil.getSessionFactory());
		eTest.createEvent();
		eTest.createEvent();
	}
	
	@Test
	public void testListEvent() {
		EventService eTest = 
				new EventService();
		//SessionFactory sf = new Configuration().configure().buildSessionFactory();
		eTest.setSessionFactory(HibernateUtil.getSessionFactory());
		Assert.assertEquals(eTest.listEvents().size(),2);
	}
}
