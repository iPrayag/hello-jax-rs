package org.jcheng.demo.jersey;

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

import org.jcheng.demo.model.Biography;
import org.springframework.stereotype.Component;

@Component
@Provider @Produces("application/json")
public class StupidJsonWriter implements
	MessageBodyWriter<Biography> {
	
	@Override
	public long getSize(Biography bio, Class<?> clazz, Type type,
			Annotation[] annotations, MediaType mediaType) { return -1;	}

	@Override
	public boolean isWriteable(Class<?> clazz, Type type, Annotation[] annotations,
			MediaType mediaType) { return true;	}

	@Override
	public void writeTo(Biography bio, Class<?> clazz, Type type,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> map, OutputStream out)
			throws IOException, WebApplicationException {
		String json = "{ \"title\":\"" + bio.getTitle() + "\", "
			      + "\"author\":\"" + bio.getAuthor().getEmail() + "\",  " 
			      + "\"body\": \"" + bio.getBody() + "\"}";
		out.write(json.getBytes());
	}


}
