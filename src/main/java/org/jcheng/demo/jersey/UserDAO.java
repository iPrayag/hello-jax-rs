package org.jcheng.demo.jersey;

import java.util.ArrayList;
import java.util.List;

import org.jcheng.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	
	private final List<User> users = new ArrayList<User>();
	{
		users.add(new User().setAlias("John").setEmail("john@example.com"));
		users.add(new User().setAlias("Mary").setEmail("mary@example.com"));
		users.add(new User().setAlias("Juan").setEmail("juan@example.com"));
	}

	
	public List<User> getUsers() {
		return this.users;
	}
	
	public User getUser(long id) {
		return users.get((int)id);
	}

}
