package fr.dawan.cvinter.ws;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.dawan.cvinter.beans.CV;
import fr.dawan.cvinter.beans.User;
import fr.dawan.cvinter.controllers.StartupListener;
import fr.dawan.cvinter.dao.CVDao;
import fr.dawan.cvinter.dao.GenericDao;
import fr.dawan.cvinter.dao.UtilisateurDao;

@Path("/users") // localhost:8080/cvinter/api/users
public class UserWS {

	@GET
	@Path("/{id}/cv/{cvId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CV findCVIdByUserId(@PathParam("id") long id, @PathParam("cvId") long cvId) throws Exception {
		// TODO vérifier que l'utilisiteur connecté correspond au paramètre.
		System.out.println("lancement requête CVById " + cvId);
		EntityManager em = StartupListener.emf.createEntityManager();
		return CVDao.findCVIdByUserId(id, cvId, em, false);
	}

	@GET
	@Path("/{id}/cv")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CV> findCVByUserId(@PathParam("id") long id) throws Exception {
		System.out.println("lancement requête CVByUser " + id);
		EntityManager em = StartupListener.emf.createEntityManager();
		return CVDao.findCVByUserId(id, em, false);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll() throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		return GenericDao.findAll(User.class, em, false);
	}

	@GET
	@Path("/{id}") // /api/products/12
	@Produces(MediaType.APPLICATION_JSON)
	public User findById(@PathParam("id") long id) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		return GenericDao.findById(User.class, id, em, false);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(User u) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.save(u, em, true);
		return Response.status(201).entity("{\"msg\":\"insertion CV OK\"}").build();
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	// @Consumes("application/json-patch+json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(User u) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.update(u, em, true);
		return Response.status(204).entity("{\"msg\":\"update CV OK\"}").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.delete(User.class, em, true);
	}

}