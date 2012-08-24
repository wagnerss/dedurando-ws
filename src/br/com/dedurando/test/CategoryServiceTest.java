package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.StatusType;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.service.CategoryService;

public class CategoryServiceTest {

	@Test
	public void save() throws BusinessException {
		CategoryService service = new CategoryService();
		Category category = new Category();
		
		category.setName("Teste");
		category.setStatus(StatusType.ACTIVE);
		category = service.save(category);
		
		Assert.assertEquals("Register error", StatusType.ACTIVE.getStatus(), category.getStatus());
	}
	
	@Test
	public void findAll(){
		Category[] categorys = new CategoryService().findAll();
		Assert.assertTrue(categorys.length > 0);
	}
	
	@Test
	public void find(){
		Category category = new Category();
		category.setCategoryId((long)1);
		Category category2 =  new CategoryService().find(category);
		Assert.assertNotSame("Find error", category2.getName(), category.getName());
	} 
}