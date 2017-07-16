package com.springtutorial.MyBlogger.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtutorial.MyBlogger.domain.Blog;
import com.springtutorial.MyBlogger.services.BlogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/blogs")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class BlogResource {

	@Autowired
	BlogService blogService;

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Successfully created blogs"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@PostMapping(path = "/create")
	public ResponseEntity<Void> createBlog(@RequestBody @Valid BlogRequest request) {

		Blog blog = request.toBlog(request);
		Blog saved = blogService.createBlog(blog);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/api/v1/blogs/create/" + saved.getId()));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

}
