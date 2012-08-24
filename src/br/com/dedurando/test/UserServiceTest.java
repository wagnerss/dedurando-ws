package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.StatusType;
import br.com.dedurando.bean.User;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.RegisterException;
import br.com.dedurando.service.UserService;

public class UserServiceTest {

	@Test
	public void register() throws RegisterException {
		UserService service = new UserService();
		User user = new User();
		//user.setUserId((long)1);
		user.setMail("davi555.psr@gmail.com");
		user.setFirstName("Davi Paulo");
		user.setLastName("Simao Ruiz");
		user.setPassword("1234");
		user.setIpAddress("192.168.7.20");
		user = service.register(user);
		
		Assert.assertEquals("Register error", StatusType.ACTIVE.getStatus(), user.getStatus());
	}
	
	@Test
	public void unRegister() throws RegisterException {
		UserService service = new UserService();
		User user = new User();
		user.setUserId((long)1);
		
		user = service.unRegister(user);
		
		Assert.assertNotSame("Unregister error", StatusType.ACTIVE, user.getStatus());
	}
	
	@Test
	public void findAll(){
		User[] users = new UserService().findAll(new User());
		Assert.assertTrue(users.length > 0);
	}
	
	@Test
	public void find(){
		User user = new User();
		user.setUserId((long)1);
		User user2 =  new UserService().find(user);
		Assert.assertNotSame("Find error", user2.getFirstName(), user.getFirstName());
	} 
	
	@Test
	public void signIn() throws BusinessException{		
		User user = new User();
		user.setUserId((long)1);
		
		new UserService().signIn(user);
	}
	
	@Test
	public void resetPassword() throws BusinessException{
		User user = new User();
		user.setUserId((long)1);
		
		new UserService().resetPassword(user);
	}
}