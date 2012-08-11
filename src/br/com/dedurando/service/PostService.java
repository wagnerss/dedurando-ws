package br.com.dedurando.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Post;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.PostBLL;

@WebService
public class PostService {
	
	@WebMethod
	public Post save(Post post) throws BusinessException{
		return new PostBLL().save(post);
	}
	
	@WebMethod
	public Post find(Post post){
		return new PostBLL().find(post);
	}
	
	@WebMethod
	public List<Post> findAll(){
		return new PostBLL().findAll();
	}
	
	@WebMethod
	public List<Post> findAllByName(Post post){
		return new PostBLL().findAllByName(post);
	}
	
	@WebMethod
	public List<Post> findAllByCategory(Category category){
		return new PostBLL().findAllByCategory(category);
	}
	
	@WebMethod
	public List<Post> findRecent(Post post){
		return new PostBLL().findRecent(post);
	}
	
}