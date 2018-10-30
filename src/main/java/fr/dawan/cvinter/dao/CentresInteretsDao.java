package fr.dawan.cvinter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.cvinter.beans.CentresInterets;

public class CentresInteretsDao {

	
	@SuppressWarnings("unchecked")
	public static List<CentresInterets> findAll(EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("SELECT c.id, c.name FROM CentresInterets i");
		List<CentresInterets> result = query.getResultList();

		if (closeConnection)
			em.close();
		return result;
	}
	
}
