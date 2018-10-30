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

import fr.dawan.cvinter.beans.Formation;
import fr.dawan.cvinter.controllers.StartupListener;
import fr.dawan.cvinter.dao.CVDao;
import fr.dawan.cvinter.dao.FormationDao;
import fr.dawan.cvinter.dao.GenericDao;

@Path("/formation")
public class FormationWS {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Formation> findAll() throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		return GenericDao.findAll(Formation.class, em, true);
	}

	@GET
	@Path("/{id}") // /api/products/12
	@Produces(MediaType.APPLICATION_JSON)
	public Formation findById(@PathParam("id") long id) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		return GenericDao.findById(Formation.class, id, em, true);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(Formation f) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.save(f, em, true);
		return Response.status(201).entity("{\"msg\":\"insertion OK\"}").build();
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	// @Consumes("application/json-patch+json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Formation f) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.update(f, em, true);
		return Response.status(204).entity("{\"msg\":\"update OK\"}").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.delete(Formation.class, em, true);
	}

}
