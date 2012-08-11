package br.com.dedurando.business;

import java.util.GregorianCalendar;
import java.util.List;

import br.com.dedurando.bean.StatusType;
import br.com.dedurando.bean.User;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class UserBLL extends BLL<User> {
	
	private DAO<User> dao = new DAO<User>(User.class);
    
	public List<User> findAll(User user){
		return dao.findAll();
	}
	
	public User find(User user){
		return dao.findByID(user.getUserId());
	}
	
	public User register(User user) throws BusinessException{
		user.setCreated_at(GregorianCalendar.getInstance());
		user.setStatus(StatusType.ACTIVE);
		
		this.validate(user);
		
		return this.save(user);
	}	
	
	public User unRegister(User user) throws BusinessException{				
		user = this.find(user);
		if(user == null){
			throw new BusinessException("Invalid user.");
		}
		user.setStatus(StatusType.INACTIVE);
			
		return this.save(user);
	}
	
	public boolean signIn(User user) throws BusinessException{		
		User userDB = this.find(user);
		
		if(userDB == null){
			throw new BusinessException("Invalid user.");
		}
		
		if (user.getPassword() != user.getPassword()){
			throw new BusinessException("Invalid user name or password.");
		}
		
		if (user.getStatus() == StatusType.INACTIVE){
			throw new BusinessException("The user is inactive.");
		}			
		
		return true;
	}
	
	public boolean resetPassword(User user) throws BusinessException{		
		user = this.find(user);
		if(user == null){
			throw new BusinessException("Invalid user.");
		}
				
		user.setResetPasswordToken("fdafd-fdas-fdsa-fads-dfsa");
		
		this.save(user);
		
		this.sendResetPassword(user);
		
		return true;
	}
	
	private void sendResetPassword(User user){
		/// TODO
	}
		
	private User save(User user) throws BusinessException
	{
		try{
			return dao.save(user);
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
	}
}