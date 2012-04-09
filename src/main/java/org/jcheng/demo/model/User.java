package org.jcheng.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
public class User {
	
	private String alias;
	private String email;

	//@XmlElement(name="userName") 
	public String getAlias() {
		return alias;
	}

	public User setAlias(String alias) {
		this.alias = alias;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

}
