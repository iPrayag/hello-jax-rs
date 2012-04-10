
package org.jcheng.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Biography {
	
	private String title;
	private String body;
	private User author;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}

}
