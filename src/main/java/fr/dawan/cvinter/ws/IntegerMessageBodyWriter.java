package fr.dawan.cvinter.ws;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class IntegerMessageBodyWriter implements MessageBodyWriter<Integer> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] arg2, MediaType mediaType) {
		return type == Integer.class;
	}

	@Override
	public void writeTo(Integer value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> headers, OutputStream out) throws IOException, WebApplicationException {
		String s = "{\"result\":" + value + "}";
		out.write(s.getBytes());

	}

}
