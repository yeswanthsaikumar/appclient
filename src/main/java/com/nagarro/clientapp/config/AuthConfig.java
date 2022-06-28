package com.nagarro.clientapp.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.clientapp.model.User;
import com.nagarro.clientapp.repository.UserRepository;

@Configuration
public class AuthConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserRepository loginRepository) {
		
		return args->{
			User yesh = new User("yesh@gmail.com","yesh");
			User yogi = new User("yogi@gmail.com","yogi");
			
			loginRepository.saveAll(List.of(yesh,yogi));
		
		};
	}
	
}
