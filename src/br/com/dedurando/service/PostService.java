package br.com.dedurando.service;

import java.util.List;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Post;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.PostBLL;

public class PostService {
	
	public Post save(Post post) throws BusinessException{
		return new PostBLL().save(post);
	}
	
	public Post find(Post post){
		return new PostBLL().find(post);
	}
	
	public List<Post> findAll(){
		return new PostBLL().findAll();
	}
	
	public List<Post> findAllByName(Post post){
		return new PostBLL().findAllByName(post);
	}
	
	public List<Post> findAllByCategory(Category category){
		return new PostBLL().findAllByCategory(category);
	}
	
	public List<Post> findRecent(Post post){
		return new PostBLL().findRecent(post);
	}
	
}