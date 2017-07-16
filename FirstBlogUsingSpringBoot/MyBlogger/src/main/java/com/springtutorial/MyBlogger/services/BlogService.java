package com.springtutorial.MyBlogger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtutorial.MyBlogger.domain.Blog;
import com.springtutorial.MyBlogger.repository.BlogRepository;

@Service
public class BlogService {
	
	private final BlogRepository blogRepository;
	
	@Autowired
	public BlogService(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}
	
	public Blog createBlog(Blog blog) {
		Blog saved = blogRepository.save(blog);
		return saved;
	}

}
