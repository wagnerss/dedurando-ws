package br.com.dedurando.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.dedurando.bean.Category;
import br.com.dedurando.bean.Post;
import br.com.dedurando.util.DAO;
import br.com.dedurando.util.JPAUtil;

public class PostDAO extends DAO<Post>{
	public PostDAO() {
		super(Post.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Post> findAllByName(String name) {
		 EntityManager em = new JPAUtil().getEntityManager();
		 return em.createQuery("select e from " + klass.getName() + " e").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Post> findAllByCategory(Category category) {
		 EntityManager em = new JPAUtil().getEntityManager();
		 return em.createQuery("select e from " + klass.getName() + " e").getResultList();
	}
}
