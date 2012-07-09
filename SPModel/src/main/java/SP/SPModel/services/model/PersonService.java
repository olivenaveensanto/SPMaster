package SP.SPModel.services.model;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import SP.SPModel.event.Event;
import SP.SPModel.event.Person;

public class PersonService {
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

	public Person createPerson(String firstname,
							  String lastname,
							  int age){
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		Person person = new Person(firstname,lastname,age);		
		session.save(person);
		endSessionTransaction(session);
		return person ;
	}
	
	public List<Person> listPersons(){
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		List<Person> events =session.createQuery("from Person").list();
		endSessionTransaction(session);
		return events;
	}
	
	public Person getPerson(String name, String lastname) throws HibernateException{
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		Person person =(Person)session.createQuery("select p from Person p where " +
				"p.firstname = :pfirstname and " +
				"p.lastname = :plastname")
				.setParameter("pfirstname", name).uniqueResult();
		endSessionTransaction(session);
		return person;
	}
	
	public Person getEvent(String name, String lastname) throws HibernateException{
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		Person person =(Person)session.createQuery("select p from Person p where " +
				"p.firstname = :pfirstname and " +
				"p.lastname = :plastname")
				.setParameter("pfirstname", name).uniqueResult();
		endSessionTransaction(session);
		return person;
	}
	
	public Set<Event> listPersonEvents(String firstname, String lastname){		
		Session session = sessionFactory.openSession();
		startSessionTransaction(session);
		Person person =(Person)session.createQuery("select p from Person p where " +
				"p.firstname = :pfirstname and " +
				"p.lastname = :plastname")
				.setParameter("pfirstname", firstname)
				.setParameter("plastname", lastname)
				.uniqueResult();		
		endSessionTransaction(session);
		return person.getEvents();
	}
}
