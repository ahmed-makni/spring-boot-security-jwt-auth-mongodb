package com.bezkoder.spring.jwt.mongodb;

import com.bezkoder.spring.jwt.mongodb.models.ERole;
import com.bezkoder.spring.jwt.mongodb.models.Role;
import com.bezkoder.spring.jwt.mongodb.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootSecurityJwtMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJwtMongodbApplication.class, args);
		
		
	}
	
	@Bean
	CommandLineRunner start (RoleRepository roleRepository) {
		return args -> {
			Stream.of(ERole.ROLE_USER,ERole.ROLE_ADMIN,ERole.ROLE_MODERATOR).forEach(un->{
				roleRepository.save(new Role(un));
			});
		};
	}

}
