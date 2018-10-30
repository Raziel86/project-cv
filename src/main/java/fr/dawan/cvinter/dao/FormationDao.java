package fr.dawan.cvinter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.cvinter.beans.Formation;

public class FormationDao {

	@SuppressWarnings("unchecked")
	public static List<Formation> findAll(EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("SELECT c.id, c.name FROM Formation c");
		List<Formation> result = query.getResultList();

		if (closeConnection)
			em.close();
		return result;
	}
	
	
}
