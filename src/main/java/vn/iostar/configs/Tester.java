package vn.iostar.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Tester {
	public static void main(String[] args) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			
			throw e;
		} finally {
			enma.close();
		}
	}
}