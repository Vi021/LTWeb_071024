package vn.iostar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@PersistenceContext
public class JPAConfig {

	private static EntityManagerFactory factory;

	// Static initializer block to ensure the factory is created only once
	static {
		try {
			factory = Persistence.createEntityManagerFactory("LTWeb081024");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManager getEntityManager() {
		if (factory != null) {
			return factory.createEntityManager();
		}
		
		return null;
	}
}
