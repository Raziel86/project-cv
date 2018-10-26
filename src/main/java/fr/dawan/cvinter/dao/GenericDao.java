package fr.dawan.cvinter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class GenericDao {

	public static <T> void save(T item, EntityManager em, boolean closeConnection) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(item);
			
			tx.commit();
		} catch (Throwable e) {
			tx.rollback();
			e.printStackTrace();
		}
		if (closeConnection)
			em.close();
	}

	public static <T> void update(T item, EntityManager em, boolean closeConnection) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(item);
			
			tx.commit();
		} catch (Throwable e) {
			tx.rollback();
			e.printStackTrace();
		}
		if (closeConnection)
			em.close();
	}
	
	public static <T> void delete(T item, EntityManager em, boolean closeConnection) {
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

				em.remove(item);
				tx.commit();
			

			if (closeConnection)
				em.close();
		} catch (Throwable e) {

		}
	}

	public static <T> T findById(Class<T> clazz, long id, EntityManager em, boolean closeConnection) {
		T result = em.find(clazz, id);

		if (closeConnection)
			em.close();
		return result;
	}

	public static <T> List<T> findAll(Class<T> clazz, EntityManager em, boolean closeConnection) {
		TypedQuery<T> query = em.createQuery("select entity from "+clazz.getName()+" entity", clazz);
	
		List<T> result = query.getResultList();
		
		if (closeConnection)
			em.close();
		return result;
	}
}
