package br.com.dedurando.business;

import java.util.List;

import br.com.dedurando.bean.Item;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class ItemBLL extends BLL<Item> {
	
	private DAO<Item> dao = new DAO<Item>(Item.class);
    
	public List<Item> findAll(){
		return dao.findAll();
	}
	
	public Item find(Item item){
		return dao.findByID(item.getItemId());
	}
	
	public Item findByName(Item item){
		return dao.findByName(item.getName());
	}
	
	public Item save(Item item) throws BusinessException{
		this.validate(item);
		return dao.save(item);
	}
}