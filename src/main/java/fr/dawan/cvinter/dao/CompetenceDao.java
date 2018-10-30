package fr.dawan.cvinter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.cvinter.beans.Competence;

public class CompetenceDao {

	
	
	@SuppressWarnings("unchecked")
	public static List<Competence> findAll(EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("SELECT c.id, c.name FROM Competence c");
		List<Competence> result = query.getResultList();

		if (closeConnection)
			em.close();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Competence> findCompetenceByCVId(long id, EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("FROM Competence c WHERE c.cv.id=?").setParameter(1, id);
		List<Competence> result = query.getResultList();

		if (closeConnection)
			em.close();
		return result;
	}
}
