package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;



@SpringBootApplication
public class UserApplication {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i=1; i<=10; i++){
					userRepository.save(new User(i, "User" + i));
				}
			}
		};
	}
}