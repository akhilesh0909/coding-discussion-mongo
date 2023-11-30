package com.ems.codingdiscussion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CodingDiscussionApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CodingDiscussionApplication.class, args);
	}

}
