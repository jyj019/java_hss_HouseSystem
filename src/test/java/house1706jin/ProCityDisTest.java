package house1706jin;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.jyj019.service.UserService;
import com.jyj019.util.HibernateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class ProCityDisTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
//		session.persist(user);
//		session.persist(login);
//		session.persist(idCard);
//		session.save(idCard2);
		session.getTransaction().commit();
		session.close();
	}

}
