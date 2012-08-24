package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Item;
import br.com.dedurando.bean.StatusType;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.service.ItemService;

public class ItemServiceTest {

	@Test
	public void save() throws BusinessException {
		ItemService service = new ItemService();
		Item item = new Item();
		
		item.setName("Item Teste");
		item.setCategory(new Category());
		item.getCategory().setCategoryId((long)1);
		item.setStatus(StatusType.ACTIVE);
		item = service.save(item);
		
		Assert.assertEquals("Register error", StatusType.ACTIVE.getStatus(), item.getStatus());
	}
	
	@Test
	public void findAll(){
		Item[] items = new ItemService().findAll();
		Assert.assertTrue(items.length > 0);
	}
	
	@Test
	public void find(){
		Item item = new Item();
		item.setItemId((long)1);
		Item item2 =  new ItemService().find(item);
		Assert.assertNotSame("Find error", item2.getName(), item.getName());
	} 
}