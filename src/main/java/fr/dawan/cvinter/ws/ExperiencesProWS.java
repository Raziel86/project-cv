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

import fr.dawan.cvinter.beans.ExperiencesPro;
import fr.dawan.cvinter.beans.Formation;
import fr.dawan.cvinter.controllers.StartupListener;
import fr.dawan.cvinter.dao.ExperiencesProDao;
import fr.dawan.cvinter.dao.GenericDao;

@Path("/experiences")
public class ExperiencesProWS {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ExperiencesPro> findAll() throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		return GenericDao.findAll(ExperiencesPro.class, em, true);
	}

	@GET
	@Path("/{id}") // /api/products/12
	@Produces(MediaType.APPLICATION_JSON)
	public ExperiencesPro findByExperiencesProByCVId(@PathParam("id") long id) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		return GenericDao.findById(ExperiencesPro.class, id, em, true);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insert(ExperiencesPro e) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.save(e, em, true);
		return Response.status(201).entity("{\"msg\":\"insertion OK\"}").build();
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	// @Consumes("application/json-patch+json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(ExperiencesPro e) throws Exception {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.update(e, em, true);
		return Response.status(204).entity("{\"msg\":\"update OK\"}").build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete() {
		EntityManager em = StartupListener.emf.createEntityManager();
		GenericDao.delete(Formation.class, em, true);
	}
	
	
}
