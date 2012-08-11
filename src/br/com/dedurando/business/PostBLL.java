package br.com.dedurando.business;

import java.util.GregorianCalendar;
import java.util.List;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Post;
import br.com.dedurando.dao.PostDAO;
import br.com.dedurando.util.BLL;

public class PostBLL extends BLL<Post> {
    
	private PostDAO dao = new PostDAO();
    
	public Post save(Post post) throws BusinessException{
		post.setCreatedAt(GregorianCalendar.getInstance());
		
		this.validate(post);		
		
		try{
			dao.save(post);
		}
		catch(Exception ex){
			if(ex.getCause().getMessage().contains("detached entity passed")){
				throw new BusinessException("Post not exists.");
			}
			else
				throw new BusinessException(ex.getCause().getMessage());
		}
		return post;
	}
	
	public Post find(Post post){
		return dao.findByID(post.getPostId());
	}
	
	public List<Post> findAll(){
		return dao.findAll();
	}
	
	public List<Post> findAllByName(Post post){
		return dao.findAllByName(post.getLegend());
	}
	
	/// TODO: Alterar query
	public List<Post> findAllByCategory(Category category){
		return dao.findAllByCategory(category);
	}
	
	/// TODO: Alterar query
	public List<Post> findRecent(Post post){
		return dao.findAll();
	}
}