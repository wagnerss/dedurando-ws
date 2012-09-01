package br.com.dedurando.rest;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.ReviewReason;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.ReviewReasonBLL;

@WebService
public class ReviewReasonService {
	
	@WebMethod
	public ReviewReason find(ReviewReason reviewReason){
		return new ReviewReasonBLL().find(reviewReason);
	} 
	
	@WebMethod
	public ReviewReason[] findAll(){
		List<ReviewReason> reviewReasons = new ReviewReasonBLL().findAll();
		return reviewReasons.toArray(new ReviewReason[reviewReasons.size()]);
	}
	
	@WebMethod
	public ReviewReason findByDescription(ReviewReason reviewReason){
		return new ReviewReasonBLL().findByDescription(reviewReason);
	}
	
	@WebMethod
	public ReviewReason save(ReviewReason reviewReason) throws BusinessException{
		return new ReviewReasonBLL().save(reviewReason);
	}
}
