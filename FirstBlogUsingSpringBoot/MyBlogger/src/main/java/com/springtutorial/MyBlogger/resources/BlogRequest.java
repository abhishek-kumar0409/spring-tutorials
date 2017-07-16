package com.springtutorial.MyBlogger.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springtutorial.MyBlogger.domain.Blog;

public class BlogRequest {
	public String title;
	public String body;

	@JsonCreator
	public BlogRequest(@JsonProperty("title") String title, @JsonProperty("body") String body) {
		this.title = title;
		this.body = body;
	}

	public Blog toBlog(BlogRequest request) {

		return new Blog(this.title, this.body);
	}

	
}
