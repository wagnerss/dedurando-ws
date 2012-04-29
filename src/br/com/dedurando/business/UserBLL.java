package br.com.dedurando.business;

import java.util.GregorianCalendar;

import br.com.dedurando.bean.StatusType;
import br.com.dedurando.bean.User;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class UserBLL extends BLL<User> {
    
	public User register(User user) throws BusinessException{
		user.setCreated_at(GregorianCalendar.getInstance());
		user.setStatus(StatusType.ACTIVE);
		
		this.validate(user);
		
		DAO<User> dao = new DAO<User>(User.class);
		try{
			dao.save(user);
		}
		catch(Exception ex){
			if(ex.getCause().getMessage().contains("detached entity passed")){
				throw new BusinessException("User not exists.");
			}
			else if(ex.getCause().getMessage().contains("DDR_USER_UK_MAIL")){
				throw new BusinessException("E-mail " + user.getMail() + " already exists.");
			}
			else
				throw new BusinessException(ex.getCause().getMessage());
		}
		return user;
	}	
	
	public User unRegister(User user) throws BusinessException{
				
		DAO<User> dao = new DAO<User>(User.class);
		user = dao.findByID(user.getUserId());
		if(user == null){
			throw new BusinessException("Invalid user.");
		}
		user.setStatus(StatusType.INACTIVE);
		try{
			dao.save(user);
		}
		catch(Exception ex){
			if(ex.getCause().getMessage().contains("detached entity passed")){
				throw new BusinessException("User not exists.");
			}
			else if(ex.getCause().getMessage().contains("DDR_USER_UK_MAIL")){
				throw new BusinessException("E-mail " + user.getMail() + " already exists.");
			}
			else
				throw new BusinessException(ex.getCause().getMessage());
		}
		return user;
	}
	
}