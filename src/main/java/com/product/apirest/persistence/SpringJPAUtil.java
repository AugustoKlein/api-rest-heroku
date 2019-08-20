package com.product.apirest.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


public class SpringJPAUtil {
	
	@PersistenceContext
	private static EntityManager em;

	public static void setEntityManager(EntityManager em) {

		SpringJPAUtil.em = em;

	}
	
	public EntityManager getEntityManager() {
		return em;
	}

	public static void close(){
		em.close();
	}
	
}
