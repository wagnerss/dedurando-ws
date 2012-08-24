package br.com.dedurando.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.dedurando.bean.Comment;
import br.com.dedurando.bean.Post;
import br.com.dedurando.bean.StatusType;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.service.CommentService;

public class CommentServiceTest {

	@Test
	public void save() throws BusinessException {
		CommentService service = new CommentService();
		Comment comment = new Comment();
		Post post = new Post();
		post.setPostId((long)1);
		comment.setPost(post);
		comment.setDescription("Teste Comment");
		comment.setStatus(StatusType.ACTIVE);
		comment = service.save(comment);
		
		Assert.assertEquals("Register error", StatusType.ACTIVE.getStatus(), comment.getStatus());
	}
	
	@Test
	public void findAll(){
		Comment[] comments = new CommentService().findAll();
		Assert.assertTrue(comments.length > 0);
	}
	
	@Test
	public void find(){
		Comment comment = new Comment();
		comment.setCommentId((long)1);
		Comment comment2 =  new CommentService().find(comment);
		Assert.assertNotSame("Find error", comment2.getDescription(), comment.getDescription());
	} 
}