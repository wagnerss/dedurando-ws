package br.com.dedurando.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Post;
import br.com.dedurando.business.BusinessException;
import br.com.dedurando.business.PostBLL;

@Path("/posts")
public class PostResource{

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Post create(Post post) throws BusinessException{
		return new PostBLL().save(post);
	}
	
	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Post find(@PathParam("id") Long id){
		Post post = new Post();
		post.setPostId(id);
		return new PostBLL().find(post);
	}

	@DELETE @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(@PathParam("id") Long id){
		Post post = new Post();
		post.setPostId(id);
		new PostBLL().delete(post);
	}
		
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Post> findAll() {
		return new PostBLL().findAll();
	}
	
	public Post[] findAllByName(Post post){
		List<Post> posts = new PostBLL().findAllByName(post);
		return posts.toArray(new Post[posts.size()]);
	}
	
	public Post[] findAllByCategory(Category category){
		List<Post> posts = new PostBLL().findAllByCategory(category);
		return posts.toArray(new Post[posts.size()]);
	}
	
	public Post[] findRecent(Post post){
		List<Post> posts = new PostBLL().findRecent(post);
		return posts.toArray(new Post[posts.size()]);
	}	
	
	public Post[] findAllByLatitudeAndLongitude(Post post){
		List<Post> posts = new PostBLL().findRecent(post);
		return posts.toArray(new Post[posts.size()]);
	}	
}