package SP.SPModel.services.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import SP.SPModel.event.Event;

public class EventService {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private void startSessionTransaction(Session session){
		session.beginTransaction();
	}
	
	private void endSessionTransaction(Session session){
		session.getTransaction().commit();
		session.flush();
		session.close();
	}

	public Event createEvent(){
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		Event event = new Event();
		event.setDate(new Date());
		event.setTitle("Event:_"+new Date());
		session.save(event);
		endSessionTransaction(session);
		return event;
	}
	
	public Event getEvent(String eventname){
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		session.createQuery("select e from Event e where e.eventname = :peventname")
		.setParameter("peventname", eventname)
		session.save(event);
		endSessionTransaction(session);
		return event;
	}
	
	public List<Event> listEvents(){
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		List<Event> events =session.createQuery("from Event").list();
		endSessionTransaction(session);
		return events;
	}
}
