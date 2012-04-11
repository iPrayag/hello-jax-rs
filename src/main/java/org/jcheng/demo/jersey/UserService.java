package org.jcheng.demo.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jcheng.demo.model.BasicStatus;
import org.jcheng.demo.model.Biography;
import org.jcheng.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Path("/users/1.0")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Service
public class UserService {
	
	@Autowired private UserDAO userDAO;

	@GET @Path("/list")
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
	@GET @Path("/get")
	public User getUserById(@QueryParam("id") long id) {
		try {
			return userDAO.getUser(id);
		} catch ( RuntimeException e ) {
			throw new WebApplicationException(
					Response.status(Status.NOT_FOUND)
							.entity(new BasicStatus("User not found")).build());
		}
	}
	
	@GET @Path("/updateEmail")
	public BasicStatus updateEmail(@QueryParam("id") int id, @QueryParam("newEmail") String newEmail) {
		User user = getUserById(id);
		if ( user != null ) {
			user.setEmail(newEmail);
		}
		return new BasicStatus();
	}
	
	@GET @Path("/getMulti")
	public List<User> updateEmail(@QueryParam("id") List<Integer> ids) {
		ArrayList<User> users = new ArrayList<User>();
		for ( Integer id : ids ) {
			users.add(getUserById(id));
		}
		return users;
	}
	
	@GET @Path("/getBio")
	public Biography getBiography(@QueryParam("id") int id) {
		Biography blogPost = new Biography();
		blogPost.setAuthor(getUserById(0));
		blogPost.setTitle("Hello World");
		blogPost.setBody("My first bio. I'm so excited!");
		return blogPost;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}