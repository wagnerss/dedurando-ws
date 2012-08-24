package br.com.dedurando.business;

import java.util.List;

import br.com.dedurando.bean.Category;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class CategoryBLL extends BLL<Category> {
	
	private DAO<Category> dao = new DAO<Category>(Category.class);
    
	public List<Category> findAll(){
		return dao.findAll();
	}
	
	public Category find(Category category){
		return dao.findByID(category.getCategoryId());
	}
	
	public Category findByName(Category category){
		return dao.findByName(category.getName());
	}
	
	public Category save(Category category) throws BusinessException{
		this.validate(category);
		return dao.save(category);
	}
}