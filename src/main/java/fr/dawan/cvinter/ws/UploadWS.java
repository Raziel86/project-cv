package fr.dawan.cvinter.ws;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import fr.dawan.cvinter.beans.CV;
import fr.dawan.cvinter.controllers.StartupListener;
import fr.dawan.cvinter.dao.GenericDao;

@Path("/upload")
public class UploadWS {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String upload(@FormDataParam("idCV") String idCV, 
			@FormDataParam("file") InputStream stream,
			@FormDataParam("file") FormDataContentDisposition fileDetails) {
		System.out.println("upload : " + idCV);
		
		String fileName = "cv_picture_" + idCV + "_" + fileDetails.getFileName();
		String fullPath = "C:\\Users\\Admin stagiaire\\git\\project-cv\\src\\main\\webapp\\images\\" + fileName;
		try {
			String basePath = new File("").getAbsolutePath();
			System.out.println(basePath);
			
			Files.copy(stream, Paths.get(fullPath), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			fullPath = e.getMessage();
		}
		EntityManager em = StartupListener.emf.createEntityManager();
		CV cv = GenericDao.findById(CV.class, Integer.parseInt(idCV), em, false);
		cv.setPicture(fileName);
		
		GenericDao.update(cv, em, true);
		
		return fileName;

	}

}
