package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	boolean existsByFirstNameAndLastName(String firstName, String lastName);
	
	Author findByFirstNameAndLastName(String firstName, String lastName);
}