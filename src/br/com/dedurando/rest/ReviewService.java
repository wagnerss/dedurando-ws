package br.com.dedurando.rest;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.dedurando.bean.Review;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.ReviewBLL;

@WebService
public class ReviewService {
	
	@WebMethod
	public Review find(Review review){
		return new ReviewBLL().find(review);
	} 
	
	@WebMethod
	public Review[] findAll(){
		List<Review> reviews = new ReviewBLL().findAll();
		return reviews.toArray(new Review[reviews.size()]);
	}
	
	@WebMethod
	public Review save(Review review) throws BusinessException{
		return new ReviewBLL().save(review);
	}
}
