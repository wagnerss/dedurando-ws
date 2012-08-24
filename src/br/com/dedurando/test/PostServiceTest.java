package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Item;
import br.com.dedurando.bean.Place;
import br.com.dedurando.bean.Post;
import br.com.dedurando.bean.StatusType;
import br.com.dedurando.bean.User;
import br.com.dedurando.business.BusinessException;
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
		
		Assert.assertEquals("Register error", StatusType.ACTIVE.getStatus(), post.getItem().getStatus());
	}
	
	@Test
	public void findAll(){
		Post[] posts = new PostService().findAll();
		Assert.assertTrue(posts.length > 0);
	}
	
	@Test
	public void find(){
		Post post = new Post();
		post.setPostId((long)1);
		Post post2 =  new PostService().find(post);
		Assert.assertNotSame("Find error", post2.getLegend(), post.getLegend());
	} 
	
	@Test
	public void findAllByName(){
		Post post = new Post();
		post.setLegend("Legenda teste");
		Post[] posts = new PostService().findAllByName(post);
		Assert.assertTrue(posts.length > 0);
	}
	
	@Test
	public void findAllByCategory(){
		Post[] posts = new PostService().findAllByCategory(new Category());
		Assert.assertTrue(posts.length > 0);
	}
		
	@Test
	public void findRecent(){
		Post[] posts = new PostService().findRecent(new Post());
		Assert.assertTrue(posts.length > 0);
	}
}