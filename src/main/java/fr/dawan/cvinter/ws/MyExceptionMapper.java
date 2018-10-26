package fr.dawan.cvinter.ws;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import fr.dawan.cvinter.beans.MyErrorMessage;

@Provider
public class MyExceptionMapper implements ExceptionMapper<Throwable> {
	// 400 BadRequestException message mal formÃ©
	// 401 NotAuthorizedException echec d'authentification
	// 403 ForbiddenException accÃ¨s refusÃ©
	// 404 NotFoundException ressource introuvable
	// 405 NotAllowedException mÃ©thode http non supportÃ©e
	// 406 NotAcceptableException mediaType du client non supportÃ©
	// 415 NotSupportedException mediaType postÃ© du client non supportÃ©
	// 500 InternalServerErrorException erreur serveur
	// 503 ServiceUnavailableException serveur temporairement indisponible ou occupÃ©
	//
	// Throwable Exception Error ..... ....
	//
	@Override
	public Response toResponse(Throwable ex) {
		MyErrorMessage m = new MyErrorMessage();

		if (ex instanceof BadRequestException)
			m.setHttpStatus(400);
		// ...

		m.setMessage(ex.getMessage());

		try {
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			m.setStackTrace(sw.toString());
			sw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(m.getHttpStatus()).entity(m).type(MediaType.APPLICATION_JSON).build();
	}

}