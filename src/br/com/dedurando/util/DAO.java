package br.com.dedurando.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAO<T> {
	
	public final Class<T> klass;
	
	public DAO(Class<T> klass) {
			this.klass = klass;
	}

	public T findByID(long id) {
			EntityManager em = new JPAUtil().getEntityManager();
			return em.find(this.klass, id);
	}

	public T findByName(String name) {
		EntityManager em = new JPAUtil().getEntityManager();
		return em.find(this.klass, name);
	}
	
	
	public T save(T entity) {
		EntityManager em = new JPAUtil().getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(entity);
		t.commit();
		return entity;
	}
	
	public T insert(T entity) {
		EntityManager em = new JPAUtil().getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(entity);
		t.commit();
		return entity;
	}
	
	public T update(T entity) {
		EntityManager em = new JPAUtil().getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(entity);
		t.commit();
		return entity;
	}
	
	public boolean delete(long id) {
		try {
			EntityManager em = new JPAUtil().getEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(this.findByID(id));
			t.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		  EntityManager em = new JPAUtil().getEntityManager();
		  return em.createQuery("from " + klass.getName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAllByStringPropertyName(String propertyName, String value){
		  EntityManager em = new JPAUtil().getEntityManager();
		  return em.createQuery("from " + klass.getName() + " as e where e." + propertyName + " like '"+ value + "'").getResultList();
	}
}