package com.example.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Demo3Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Demo3Application.class);
	
	//@RequestMapping("/")
	//	String home (){
	//		return "Hello world";
	//	}

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
		//logger.info("Message loaded at info level");
		//logger.debug("Message loaded at debug level");
		//logger.warn("Message loaded at Warn Level");
		//logger.error("Message loaded at Error level");
		
	}
}
