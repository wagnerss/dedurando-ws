package br.com.dedurando.rest;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dedurando.bean.Category;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.CategoryBLL;

@WebService
@Path("/categories")
public class CategoryResource {
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Category find(@PathParam("id") String id) {
		System.out.println("findById " + id);
		Category category = new Category();
		category.setCategoryId((long) Integer.parseInt(id));
		return new CategoryBLL().find(category);
	}
	
	@WebMethod
	public Category[] findAll(){
		List<Category> categorys = new CategoryBLL().findAll();
		return categorys.toArray(new Category[categorys.size()]);
	}
	
	@WebMethod
	public Category findByName(Category category){
		return new CategoryBLL().findByName(category);
	}
	
	@WebMethod
	public Category save(Category category) throws BusinessException{
		return new CategoryBLL().save(category);
	}
}