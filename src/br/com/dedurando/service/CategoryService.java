package br.com.dedurando.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.Category;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.CategoryBLL;

@WebService
public class CategoryService {
	
	@WebMethod
	public Category find(Category category){
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
