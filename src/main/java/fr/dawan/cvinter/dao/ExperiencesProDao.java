package fr.dawan.cvinter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.cvinter.beans.ExperiencesPro;

public class ExperiencesProDao {
	@SuppressWarnings("unchecked")
	public static List<ExperiencesPro> findAll(EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("SELECT c.id, c.name FROM ExperiencesPro e");
		List<ExperiencesPro> result = query.getResultList();

		if (closeConnection)
			em.close();
		return result;
	}
}
