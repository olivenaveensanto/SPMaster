package SP.SPModel.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class SPModelHibernateTest {
	
	@Test
	public void testConnection(){
		SessionFactory hSessFact= new Configuration().configure().buildSessionFactory();
		Session hSess = hSessFact.openSession();
		
		SPUser user1 = new SPUser();
		user1.setUid(2);
		user1.setUsername("user1");
		user1.setPassword("pass1");
		hSess.beginTransaction();
		hSess.save(user1);
		hSess.getTransaction().commit();
		hSess.flush();
		hSess.close();		
	}

}
