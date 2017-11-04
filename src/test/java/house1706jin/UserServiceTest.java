package house1706jin;

import com.jyj019.dto.UserRegisterDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jyj019.domain.User;
import com.jyj019.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testLogin() {
		User user = new User();
		user.setUsername("hellokitty");
		user.setPassword("1qaz2wsx");
	//	userService.login(user);
	}
	
	@Test
	public void testRegister() {
		UserRegisterDto user = new UserRegisterDto();
		user.setUsername("oneshit");
		user.setPassword("2233");
		user.setRepassword("2233");
		//String md5 = DigestUtils.md5Hex(user.getPassword());
		user.setRealname("2");
		user.setTel("13500998765");
		user.setAdmin(null);
		//User user1=new User(user.getUsername(), md5,user.getRealname(),user.getTel(),false);
		Assert.assertTrue(userService.register(user));
		//   userService.register(user);
	}
}
