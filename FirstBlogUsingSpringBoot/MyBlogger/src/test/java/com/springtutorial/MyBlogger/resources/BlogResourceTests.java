package com.springtutorial.MyBlogger.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BlogResourceTests {

	@Autowired
	MockMvc mockMvc;

	@Test()
	public void createMockMvcObject() {
		assertThat(mockMvc).isNotNull();
	}

	@Test
	public void should_create_blog() throws Exception {

		String json = "{\"title\":\"My first post\", \"body\":\"My awesome first blog\"}";

		mockMvc.perform(post("/api/v1/blogs/create").contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isCreated()).andDo(print()).andExpect(header().string("location", "/api/v1/blogs/create/1"));

	}

}
