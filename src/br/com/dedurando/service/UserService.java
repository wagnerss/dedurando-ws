package br.com.dedurando.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.User;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.RegisterException;
import br.com.dedurando.business.UserBLL;

@WebService
public class UserService {
	
	@WebMethod
	public User register(User user) throws RegisterException{
		try {
			return new UserBLL().register(user);
		} catch (BusinessException e) {
			throw new RegisterException(e.getMessage());
		}
	}
	
	@WebMethod
	public User unRegister(User user) throws RegisterException{
		try {
			return new UserBLL().unRegister(user);
		} catch (BusinessException e) {
			throw new RegisterException(e.getMessage());
		}
	}
	
	@WebMethod
	public User[] findAll(User user){
		List<User> users = new UserBLL().findAll(user);
		return users.toArray(new User[users.size()]);
	}
	
	@WebMethod
	public User find(User user){
		return new UserBLL().find(user);
	} 
	
	@WebMethod
	public boolean signIn(User user) throws BusinessException{		
		return new UserBLL().signIn(user);
	}
	
	@WebMethod
	public boolean resetPassword(User user) throws BusinessException{		
		return new UserBLL().resetPassword(user);
	}
}
