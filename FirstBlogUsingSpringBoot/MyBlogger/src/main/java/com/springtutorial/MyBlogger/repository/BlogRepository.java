package com.springtutorial.MyBlogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springtutorial.MyBlogger.domain.Blog;

public interface BlogRepository extends JpaRepository<Blog, String> {
	

}
