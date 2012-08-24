package br.com.dedurando.business;

import java.util.GregorianCalendar;
import java.util.List;

import br.com.dedurando.bean.Review;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class ReviewBLL extends BLL<Review> {
	
	private DAO<Review> dao = new DAO<Review>(Review.class);
    
	public List<Review> findAll(){
		return dao.findAll();
	}
	
	public Review find(Review review){
		return dao.findByID(review.getReviewId());
	}	
	
	public Review save(Review review) throws BusinessException{
		review.setCreatedAt(GregorianCalendar.getInstance());
		
		this.validate(review);
		
		return dao.save(review);
	}
}