package br.com.dedurando.test;

import org.junit.Test;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Item;
import br.com.dedurando.bean.Place;
import br.com.dedurando.bean.Post;
import br.com.dedurando.bean.User;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.PostBLL;
import br.com.dedurando.service.PostService;
import br.com.dedurando.util.DAO;

public class PostServiceTest {

	@Test
	public void save() throws BusinessException {
		PostService service = new PostService();
		Post post = new Post();
		
		post.setItem(new DAO<Item>(Item.class).findByID(1));
		post.setPlace(new DAO<Place>(Place.class).findByID(1));
		post.setUser(new DAO<User>(User.class).findByID(1));
		post.setLegend("Legenda teste");
		post.setPhoto(new byte[]{});
		post = service.save(post);
		
		//Assert.assertEquals("Register error", StatusType.ACTIVE, post.getStatus());
	}
	
	@Test
	public void find(){
		new PostBLL().findAll();
	}
	
	@Test
	public void findAll(){
		new PostBLL().findAll();
	}
	
	@Test
	public void findAllByName(){
		new PostBLL().findAll();
	}
	
	@Test
	public void findAllByCategory(){
		new PostBLL().findAll();
	}
		
	@Test
	public void findRecent(){
		new PostBLL().findAll();
	}
}