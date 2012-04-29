package br.com.dedurando.service;

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
}
