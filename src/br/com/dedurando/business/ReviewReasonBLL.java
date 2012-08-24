package br.com.dedurando.business;

import java.util.List;

import br.com.dedurando.bean.ReviewReason;
import br.com.dedurando.util.BLL;
import br.com.dedurando.util.DAO;

public class ReviewReasonBLL extends BLL<ReviewReason> {
	
	private DAO<ReviewReason> dao = new DAO<ReviewReason>(ReviewReason.class);
    
	public List<ReviewReason> findAll(){
		return dao.findAll();
	}
	
	public ReviewReason find(ReviewReason reviewReason){
		return dao.findByID(reviewReason.getReviewReasonId());
	}
	
	public ReviewReason findByDescription(ReviewReason reviewReason){
		return dao.findByName(reviewReason.getDescription());
	}
	
	public ReviewReason save(ReviewReason reviewReason) throws BusinessException{
		this.validate(reviewReason);
		return dao.save(reviewReason);
	}
}