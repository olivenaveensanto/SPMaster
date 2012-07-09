package SP.SPModel.event;

import java.util.HashSet;
import java.util.Set;

public class Person {
	private Long id; 
	private int age;
	private String firstname;
	private String lastname;
	private Set<Event> events = new HashSet<Event>();	
	
	public Person() {
		super();
	}
	
	public Person(String firstname, String lastname, int age) {
		super();		
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
