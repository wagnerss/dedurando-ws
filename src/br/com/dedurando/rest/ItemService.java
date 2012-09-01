package br.com.dedurando.rest;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.Item;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.ItemBLL;

@WebService
public class ItemService {
	
	@WebMethod
	public Item find(Item item){
		return new ItemBLL().find(item);
	} 
	
	@WebMethod
	public Item[] findAll(){
		List<Item> items = new ItemBLL().findAll();
		return items.toArray(new Item[items.size()]);
	}
	
	@WebMethod
	public Item findByName(Item item){
		return new ItemBLL().findByName(item);
	}
	
	@WebMethod
	public Item save(Item item) throws BusinessException{
		return new ItemBLL().save(item);
	}
}
