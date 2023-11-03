package com.example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Book {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String publisher;
	private int pubYear;
	private int pageAmount;
	private String genre;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;

	public Book() {
	}

	public Book(String title, String publisher, int pubYear, int pageAmount, String genre) {
		this.title = title;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.pageAmount = pageAmount;
		this.genre = genre;

	}

	public Book(int id, String title, String publisher, int pubYear, int pageAmount, String genre) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.pageAmount = pageAmount;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public int getPageAmount() {
		return pageAmount;
	}

	public void setPageAmount(int pageAmount) {
		this.pageAmount = pageAmount;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}