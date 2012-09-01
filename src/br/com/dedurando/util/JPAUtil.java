package br.com.dedurando.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public JPAUtil(){
		try {
			emf = Persistence.createEntityManagerFactory("development");	
		} catch (Exception e) {
			System.out.println("Cannot create Entity Manager Factory. Please verify your JPAUtil configuration. Error: " + e.getMessage());
		}		 
	}
	
	private static EntityManagerFactory emf;

	public EntityManager getEntityManager() {
			return emf.createEntityManager();
	}

}
