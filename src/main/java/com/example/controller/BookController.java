package com.example.controller;

import com.example.model.Author;
import com.example.model.Book;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	@Autowired
	BookRepository bookRepo;

	@Autowired
	AuthorRepository authorRepo;

	@GetMapping({ "/ViewAll", "/" })
	public String ViewAllBooks(Model model) {
		if (bookRepo.findAll().isEmpty()) {
			return AddNewBook(model);
		}
		model.addAttribute("books", bookRepo.findAll());
		return "AllBooks";
	}

	@GetMapping("/AddBook")
	public String AddNewBook(Model model) {
		Book b = new Book();
		model.addAttribute("NewBook", b);
		return "AddBook";
	}

	@PostMapping("/AddBook")
	public String AddNewBook(@ModelAttribute Book b, Model model) {
		if (authorRepo.existsByFirstNameAndLastName(b.getAuthor().getFirstName(), b.getAuthor().getLastName())) {
			System.out.println("Success!");
		}

		bookRepo.save(b);
		return "redirect:/books/";
	}

	@GetMapping("/Edit/{id}")
	public String EditBook(@PathVariable("id") long id, Model model) {
		Book b = bookRepo.findById(id).orElse(null);
		model.addAttribute("NewBook", b);
		return "AddBook";
	}

	@PostMapping("/Update/{id}")
	public String UpdateBook(Book b, Model model) {
		if (authorRepo.existsByFirstNameAndLastName(b.getAuthor().getFirstName(), b.getAuthor().getLastName())) {
			Author existingAuthor = authorRepo.findByFirstNameAndLastName(b.getAuthor().getFirstName(),
					b.getAuthor().getLastName());
			b.setAuthor(existingAuthor);
		}

		bookRepo.save(b);
		return "redirect:/books/";
	}

	@GetMapping("/Delete/{id}")
	public String DeleteBook(Book b, Model model) {
		bookRepo.delete(b);
		return ViewAllBooks(model);
	}

	@GetMapping("/ViewAllAuthors")
	public String ViewAllAuthors(Model model) {
		if (authorRepo.findAll().isEmpty()) {
			return ViewAllBooks(model);
		}
		model.addAttribute("authors", authorRepo.findAll());
		return "AllAuthors";
	}

	@GetMapping("/DeleteAuthor/{id}")
	public String DeleteAuthor(Author a, Model model) {
		authorRepo.delete(a);
		return ViewAllAuthors(model);
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
}




