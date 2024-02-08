package com.example.springmanytomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmanytomany.model.Book;
import com.example.springmanytomany.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getBooks();
	}

	@GetMapping("{id}")
	public Book getBook(@PathVariable(name = "id") int id) {
		return bookService.getBook(id);
	}

	@PutMapping("{id}")
	public Book updateBook(@PathVariable(name = "id") int id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping("{id}")
	public String deleteBook(@PathVariable(name = "id") int id) {
		bookService.deleteBook(id);
		return "Book with " + id + " deleted";
	}

}
