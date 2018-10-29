package fr.dawan.cvinter.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.cvinter.beans.Login;
import fr.dawan.cvinter.beans.User;

public class AuthenticationDao {

	
	public static User findUser(User u, EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("FROM user u WHERE u.email = ? and u.mpd = ?").setParameter(1, u.getEmail()).setParameter(2, u.getMdp());
		User user = (User) query.getSingleResult();
		
		if (closeConnection)
			em.close();
		
		return user;	
	}
	
//	public static User findUser(Login login, EntityManager em, boolean closeConnection) {
//		Query query = em.createQuery("FROM user u WHERE u.email = ? and u.mpd = ?").setParameter(1, login.getEmail()).setParameter(2, login.getPassword());
//		User user = (User) query.getSingleResult();
//		
//		if (closeConnection)
//			em.close();
//		
//		return user;	
//	}
}
