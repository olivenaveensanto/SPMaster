package SP.SPModel.model;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SPUserTest {

	@Test
	public void test() {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new 
				ClassPathResource("springs-config.xml"));
		SPUser user = beanFactory.getBean("spuser",SPUser.class);
		System.out.println ("got bean name :"+ user.getUsername());
	}
	

}
