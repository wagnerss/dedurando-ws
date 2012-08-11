package br.com.dedurando.service;

import java.util.List;
import br.com.dedurando.bean.User;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.RegisterException;
import br.com.dedurando.business.UserBLL;

public class UserService {
	
	public User register(User user) throws RegisterException{
		try {
			return new UserBLL().register(user);
		} catch (BusinessException e) {
			throw new RegisterException(e.getMessage());
		}
	}
	
	public User unRegister(User user) throws RegisterException{
		try {
			return new UserBLL().unRegister(user);
		} catch (BusinessException e) {
			throw new RegisterException(e.getMessage());
		}
	}
	
	public List<User> findAll(User user){
		return new UserBLL().findAll(user);
	}
	
	public User find(User user){
		return new UserBLL().find(user);
	} 
	
	public boolean signIn(User user) throws BusinessException{		
		return new UserBLL().signIn(user);
	}
	
	public boolean resetPassword(User user) throws BusinessException{		
		return new UserBLL().resetPassword(user);
	}
}
