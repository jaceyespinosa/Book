package com.example.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.model.Author;
import com.example.model.Book;

@Configuration
public class BeanConfiguration {

	@Bean
	Author author() {
		Author newAuthor = new Author();
		return newAuthor;
	}

	@Bean
	@Scope("prototype")
	Book book() {
		Book newBook = new Book();
		return newBook;
	}

}
