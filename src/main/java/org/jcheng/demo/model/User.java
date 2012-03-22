/**
 * 
 */
package org.jcheng.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model of the ubiquitous 'User'.
 * 
 * <p>A User model is only required because JAX-RS output formatting has a dependency on JAXB-style 
 * 'formatting' annotations. In other words, JAX-RS cannot automatically format core Java objects like Map,
 * List, and Collections.</p>
 * 
 * @author jcheng
 */
@XmlRootElement
public class User {
	
	private List<String> messages = new ArrayList<String>();

	private String alias;
	
	private String email;

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	


}
