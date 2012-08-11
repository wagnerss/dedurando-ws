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
		user.setMail("davi555.psr@gmail.com");
		user.setFirstName("Davi Paulo");
		user.setLastName("Simao Ruiz");
		user.setPassword("1234");
		user.setIpAddress("192.168.7.20");
		user = service.register(user);
		
		Assert.assertEquals("Register error", StatusType.ACTIVE, user.getStatus());
	}
	
	@Test
	public void unRegister() throws RegisterException {
		UserService service = new UserService();
		User user = new User();
		user.setUserId((long)25);
		
		user = service.unRegister(user);
		
		Assert.assertEquals("Unregister error", StatusType.ACTIVE, user.getStatus());
	}
	
	@Test
	public void findAll(User user){
		new UserService().findAll(user);
	}
	
	@Test
	public void find(User user){
		new UserService().find(user);
	} 
	
	@Test
	public void signIn(User user) throws BusinessException{		
		new UserService().signIn(user);
	}
	
	@Test
	public boolean resetPassword(User user){		
		return resetPassword(user);
	}
}