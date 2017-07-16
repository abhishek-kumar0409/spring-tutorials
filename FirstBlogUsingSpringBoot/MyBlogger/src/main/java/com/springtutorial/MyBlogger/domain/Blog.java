package com.springtutorial.MyBlogger.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String id;
	public String title;
	public String body;
	public int wordCount;

	public Blog(String title, String body) {
		this.body = body;
		this.title = title;

	}
	
	public Blog(String id, String title, String body) {
		this.id = id;
		this.body = body;
		this.title = title;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}
