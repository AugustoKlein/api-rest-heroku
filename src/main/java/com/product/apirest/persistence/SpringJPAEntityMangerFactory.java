package com.product.apirest.persistence;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;


public class SpringJPAEntityMangerFactory {
	// The JNDI name of the DataSource.jdbc:postgresql://localhost:5432/mydb

		public static final String DATA_SOURCE_NAME = "java:comp/env/jdbc";

		// The package name which contains all the model classes.

		public static final String PERSISTENCE_UNIT_NAME = "default";

		// * The static {@link EntityManagerFactory}
		
		private static EntityManagerFactory entityManagerFactory = null;

		public SpringJPAEntityMangerFactory() {
				entityManagerFactory = getEntityManagerFactory();
		}
		/*
		 * Returns the singleton EntityManagerFactory instance for accessing the
		 * default database.
		 * 
		 * @return the singleton EntityManagerFactory instance
		 * 
		 * @throws NamingException if a naming exception occurs during
		 * initialization
		 * 
		 * @throws SQLException if a database exception occurs during initialization
		 */
		
		public static synchronized EntityManagerFactory getEntityManagerFactory() {
			
		try{
			if (entityManagerFactory == null) {
				InitialContext ctx = new InitialContext();

				Object dsResult = ctx.lookup(DATA_SOURCE_NAME);

				DataSource ds = (DataSource) dsResult;

				Map<String, Object> properties = new HashMap<String, Object>();
				properties.put("javax.persistence.nonJtaDataSource", ds);
				entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties);
				//SpringJPAUtil.setEntityManagerFactory(entityManagerFactory);
				}	
			}catch (Exception e) {
				// TODO: handle exception
			}
		
			return entityManagerFactory;
		}

}
