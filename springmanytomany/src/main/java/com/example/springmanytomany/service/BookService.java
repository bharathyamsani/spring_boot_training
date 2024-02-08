package com.example.springmanytomany.service;

import java.util.List;

import com.example.springmanytomany.model.Book;

public interface BookService {
	Book addBook(Book b);

	List<Book> getBooks();

	Book getBook(int id);

	Book updateBook(int id, Book b);

	void deleteBook(int id);

}
