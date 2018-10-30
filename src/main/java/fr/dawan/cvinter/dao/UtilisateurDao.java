package fr.dawan.cvinter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.cvinter.beans.CV;
import fr.dawan.cvinter.beans.User;

public class UtilisateurDao {

	public static int create(User candidat) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost/cv", "root", "");
		PreparedStatement preparedStatement = cnx.prepareStatement(
				"INSERT INTO candidats (nom, prenom, email, password) values (?, ?, ?, ?)",
				PreparedStatement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, candidat.getNom());
		preparedStatement.setString(2, candidat.getPrenom());
		preparedStatement.setString(3, candidat.getEmail());
		preparedStatement.setString(4, candidat.getPassword());
		int nb = preparedStatement.executeUpdate();

		cnx.close();
		return nb;
	}

	public static void delete(User candidat) {
	}
}
