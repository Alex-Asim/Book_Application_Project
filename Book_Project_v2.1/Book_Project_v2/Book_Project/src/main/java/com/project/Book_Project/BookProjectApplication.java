package com.project.Book_Project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookProjectApplication {

	@Bean
	//	ModelMapper is a tool which helps to convert an object from one type to another, usually we use it in data models.
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookProjectApplication.class, args);
	}

}
