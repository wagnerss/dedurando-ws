package br.com.dedurando.rest;

import java.util.List;

import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dedurando.bean.User;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.RegisterException;
import br.com.dedurando.business.UserBLL;

@Path("/users")
public class UserResource {
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User register(User user) throws RegisterException{
		try {
			return new UserBLL().register(user);
		} catch (BusinessException e) {
			throw new RegisterException(e.getMessage());
		}
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
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
