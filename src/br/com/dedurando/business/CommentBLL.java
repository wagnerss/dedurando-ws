package br.com.dedurando.business;

import java.util.GregorianCalendar;
import java.util.List;

import br.com.dedurando.bean.Comment;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class CommentBLL extends BLL<Comment> {
	
	private DAO<Comment> dao = new DAO<Comment>(Comment.class);
    
	public List<Comment> findAll(){
		return dao.findAll();
	}
	
	public Comment find(Comment comment){
		return dao.findByID(comment.getCommentId());
	}
	
	public Comment findByDescription(Comment comment){
		return dao.findByName(comment.getDescription());
	}
	
	public Comment save(Comment comment) throws BusinessException{
		comment.setCreated_at(GregorianCalendar.getInstance());
		
		this.validate(comment);
		
		return dao.save(comment);
	}
}