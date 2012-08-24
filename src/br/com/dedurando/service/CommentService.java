package br.com.dedurando.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.Comment;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.CommentBLL;

@WebService
public class CommentService {
	
	@WebMethod
	public Comment find(Comment comment){
		return new CommentBLL().find(comment);
	} 
	
	@WebMethod
	public Comment[] findAll(){
		List<Comment> comments = new CommentBLL().findAll();
		return comments.toArray(new Comment[comments.size()]);
	}
	
	@WebMethod
	public Comment findByDescription(Comment comment){
		return new CommentBLL().findByDescription(comment);
	}
	
	@WebMethod
	public Comment save(Comment comment) throws BusinessException{
		return new CommentBLL().save(comment);
	}
}
