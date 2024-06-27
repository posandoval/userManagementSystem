package com.posandoval.UserManagementSystem;

import com.posandoval.UserManagementSystem.model.User;
import com.posandoval.UserManagementSystem.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserManagementSystemApplication {

	public static void main(String[] args) {

	SpringApplication.run(UserManagementSystemApplication.class, args);

	}

}
