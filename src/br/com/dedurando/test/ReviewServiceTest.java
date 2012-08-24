package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.Post;
import br.com.dedurando.bean.Review;
import br.com.dedurando.bean.ReviewReason;
import br.com.dedurando.bean.User;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.service.ReviewService;

public class ReviewServiceTest {

	@Test
	public void save() throws BusinessException {
		ReviewService service = new ReviewService();
		Review review = new Review();
		Post post = new Post();
		post.setPostId((long)1);
		review.setPost(post);
		review.setStatus('S');
		ReviewReason reviewReason = new ReviewReason();
		reviewReason.setReviewReasonId((long)1);
		review.setReviewReason(reviewReason);
		User user = new User();
		user.setUserId((long)1);
		review.setUser(user);
		review = service.save(review);
		
		Assert.assertEquals("Register error", 'S', review.getStatus());
	}
	
	@Test
	public void findAll(){
		Review[] reviews = new ReviewService().findAll();
		Assert.assertTrue(reviews.length > 0);
	}
	
	@Test
	public void find(){
		Review review = new Review();
		review.setReviewId((long)1);
		Review review2 =  new ReviewService().find(review);
		Assert.assertNotSame("Find error", review2.getStatus(), review.getStatus());
	} 
}