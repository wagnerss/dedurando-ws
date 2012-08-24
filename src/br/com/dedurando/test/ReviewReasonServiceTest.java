package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.ReviewReason;
import br.com.dedurando.bean.StatusType;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.service.ReviewReasonService;

public class ReviewReasonServiceTest {

	@Test
	public void save() throws BusinessException {
		ReviewReasonService service = new ReviewReasonService();
		ReviewReason reviewReason = new ReviewReason();
		
		reviewReason.setDescription("Teste Review Reason");
		reviewReason.setStatus(StatusType.ACTIVE);
		reviewReason = service.save(reviewReason);
		
		Assert.assertEquals("Register error", StatusType.ACTIVE.getStatus(), reviewReason.getStatus());
	}
	
	@Test
	public void findAll(){
		ReviewReason[] reviewReasons = new ReviewReasonService().findAll();
		Assert.assertTrue(reviewReasons.length > 0);
	}
	
	@Test
	public void find(){
		ReviewReason reviewReason = new ReviewReason();
		reviewReason.setReviewReasonId((long)1);
		ReviewReason reviewReason2 =  new ReviewReasonService().find(reviewReason);
		Assert.assertNotSame("Find error", reviewReason2.getDescription(), reviewReason.getDescription());
	} 
}