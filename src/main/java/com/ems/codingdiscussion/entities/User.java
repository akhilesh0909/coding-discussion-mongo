package com.ems.codingdiscussion.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {

	public static final String SEQUENCE_NAME = "employees_sequence";

	@Id
	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;

	private boolean isAdmin = false;
	
	private boolean isLocked = false;
}
