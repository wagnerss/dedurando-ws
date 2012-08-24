package br.com.dedurando.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Post;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.PostBLL;

@WebService
public class PostService{

	@WebMethod
	public Post save(Post post) throws BusinessException{
		return new PostBLL().save(post);
	}
	
	@WebMethod
	public Post find(Post post){
		return new PostBLL().find(post);
	}
	
	@WebMethod
	public Post[] findAll(){
		List<Post> posts = new PostBLL().findAll();
		return posts.toArray(new Post[posts.size()]);
	}
	
	@WebMethod
	public Post[] findAllByName(Post post){
		List<Post> posts = new PostBLL().findAllByName(post);
		return posts.toArray(new Post[posts.size()]);
	}
	
	@WebMethod
	public Post[] findAllByCategory(Category category){
		List<Post> posts = new PostBLL().findAllByCategory(category);
		return posts.toArray(new Post[posts.size()]);
	}
	
	@WebMethod
	public Post[] findRecent(Post post){
		List<Post> posts = new PostBLL().findRecent(post);
		return posts.toArray(new Post[posts.size()]);
	}	
	
	@WebMethod
	public Post[] findAllByLatitudeAndLongitude(Post post){
		List<Post> posts = new PostBLL().findRecent(post);
		return posts.toArray(new Post[posts.size()]);
	}	
}