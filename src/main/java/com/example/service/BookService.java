package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public void deleteById(Long id) {
		bookRepository.deleteById(id);
	}
}