package fr.dawan.cvinter.beans;

import java.sql.SQLException;

import fr.dawan.cvinter.dao.UtilisateurDao;

public class MainProgram {

	public static void main(String[] args) {
		Utilisateur candidat = new Utilisateur("Geoffrey", "Vanacker", "gv@cool.fr", "ohoh");

		try {
			int x = UtilisateurDao.create(candidat);
			if (x > 0)
				System.out.println("Insertion ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
