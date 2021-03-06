package fr.dawan.cvinter.ws;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.dawan.cvinter.beans.Login;
import fr.dawan.cvinter.beans.User;
import fr.dawan.cvinter.controllers.StartupListener;
import fr.dawan.cvinter.dao.AuthenticationDao;

@Path("/authentification")
public class AuthenticationWS {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("email") String email, @FormParam("password") String password) throws Exception {
//		System.out.println("User : " + login.getEmail() + " - " + login.getPassword());

		System.out.println("User : " + email + " - " + password);
		EntityManager em = StartupListener.emf.createEntityManager();
		
		User u = AuthenticationDao.findUser(new Login(email, password), em, false);
		System.out.println(u);
		if(u!=null && u.getId() > 0 ) {
			
			// session
			return Response.status(200).entity(u).build();
		}
		
		return Response.status(500).entity("{\"msg\":\"Echec de l'authentification\"}").build();
	}
	
	

	
//	@POST
//	@Path("/test3")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response test2() throws Exception {
//		EntityManager em = StartupListener.emf.createEntityManager();
//		
//		
//		return Response.status(200).entity("{\"msg\":\"Helloooooo\"}").build();
//	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response login(Login login) throws Exception {
//		System.out.println("Login : " + login.getEmail() + " - " + login.getPassword());
//		EntityManager em = StartupListener.emf.createEntityManager();
//		
//		User u = AuthenticationDao.findUser(login, em, true);
//		System.out.println(u);
//		if(u!=null && u.getId() > 0 ) {
//			
//			// session
//			return Response.status(200).entity(u).build();
//		}
//		
//		return Response.status(500).entity("{\"msg\":\"Echec de l'authentification\"}").build();
//	
//}
}
