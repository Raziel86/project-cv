package fr.dawan.cvinter.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.cvinter.beans.CV;
import fr.dawan.cvinter.beans.CVTemplate;
import fr.dawan.cvinter.beans.CentresInterets;
import fr.dawan.cvinter.beans.Competence;
import fr.dawan.cvinter.beans.ExperiencesPro;
import fr.dawan.cvinter.beans.Formation;
import fr.dawan.cvinter.beans.Login;
import fr.dawan.cvinter.beans.User;
import fr.dawan.cvinter.dao.GenericDao;

/**
 * Servlet implementation class TestDataController
 */
@WebServlet("/insert-data")
public class TestDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestDataController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = StartupListener.emf.createEntityManager();

		User admin1 = new User("Admin1", "prenadmin1", "admin1@dawan.fr", "admin1", "1 sentier mallet Mons",
				"03 20 01 02 03", new Date(), true);
		User u2 = new User("user2", "prenUtil1", "user2@dawan.fr", "user2", "rue de la paix lille", "066666",
				new Date(), false);

		GenericDao.save(admin1, em, false);
		GenericDao.save(u2, em, false);

		CV cv1 = new CV();
		cv1.setUser(GenericDao.findById(User.class, 1, em, false));

		cv1.setName("test1");

		Formation f1 = new Formation("Java Jee", new Date(), new Date(), "Lille", "blablabla");
//		f1.setCv(cv1);
		cv1.getFormations().add(f1);

		ExperiencesPro exp1 = new ExperiencesPro("developpeur java", "GvMax", new Date(), new Date(), "blebleble");
//		exp1.setCv(cv1);
		cv1.getExperiences().add(exp1);

		List<String> tags = new ArrayList<>();
		tags.add("Java 8");
		tags.add("JS");
		Competence comp1 = new Competence("Informatique", tags);
//		comp1.setCv(cv1);
		cv1.getCompetences().add(comp1);

		CentresInterets ci1 = new CentresInterets("escalade");
//		ci1.setCv(cv1);
		cv1.getHobbies().add(ci1);

		CVTemplate templ1 = new CVTemplate();
		templ1.setName("mon template 1");
		cv1.setTemplate(templ1);

		CV cv2 = new CV();
		cv2.setUser(GenericDao.findById(User.class, 2, em, false));
		cv2.setName("test2");

		Formation f2 = new Formation("Angular", new Date(), new Date(), "Lomme", "c'est compliqué");
		cv2.getFormations().add(f2);

		ExperiencesPro exp2 = new ExperiencesPro("commercial", "dawan", new Date(), new Date(), "des POE partout");
		cv2.getExperiences().add(exp2);

		List<String> tags2 = new ArrayList<>();
		tags2.add("Vente");
		tags2.add("prospection");
		tags2.add("négociation");
		
		Competence comp2 = new Competence("Commerce", tags2);
		cv2.getCompetences().add(comp2);

		CentresInterets ci2 = new CentresInterets("cinema");
		cv2.getHobbies().add(ci2);

		CVTemplate templ2 = new CVTemplate();
		templ2.setName("template test 2");
		cv1.setTemplate(templ2);

		GenericDao.save(cv1, em, false);
		GenericDao.save(cv2, em, false);

		response.getWriter().append("insertions effectuées");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
