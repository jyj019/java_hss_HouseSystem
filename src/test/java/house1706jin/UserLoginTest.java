package house1706jin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.jyj019.domain.User;
import com.jyj019.dto.UserLoginDto;
import com.jyj019.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserLoginTest {
	

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void testLoginAndRegister() {
//		userLoginDto user=new User("qing","123456", "qingxing","123456",false);
//		userService.login(user);
//		userService.register(user);
	}
	/*
	@Test
	public void testSave() {
		User user=new User("qing","123456", "qingxing","123456",false);
		Date date = new Date();
		LoginLog login=new LoginLog(user, "2233",date);
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.persist(user);
		session.persist(login);
//		session.persist(idCard);
//		session.save(idCard2);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		User user=session.get(User.class,1);
		LoginLog login=session.get(LoginLog.class,1);
		System.out.println("====华丽的分割线====");
		System.out.println(user.getUsername());
		System.out.println(user.getRealname());
		System.out.println(login.getIpaddr());
		session.getTransaction().commit();
		session.close();
	}
	*/
}
