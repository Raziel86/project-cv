package fr.dawan.cvinter.ws;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("api") // applicationPath = mapping du web.xml
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		packages("fr.dawan.cvinter.ws");

		// support du JSON et du XML
		register(JacksonFeature.class);

		// support de l'upload
		register(MultiPartFeature.class);

		// properties du serveur (à supprimer en production)
		property(ServerProperties.TRACING, "ALL");
	}

}
