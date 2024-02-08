package com.example.springmanytomany.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmanytomany.model.Author;
import com.example.springmanytomany.model.Book;
import com.example.springmanytomany.model.Genre;
import com.example.springmanytomany.repository.AuthorRepository;
import com.example.springmanytomany.repository.BookRepository;
import com.example.springmanytomany.repository.GenreRepository;
import com.example.springmanytomany.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Book addBook(Book b) {
		List<Genre> genres = new ArrayList<>();
		for (Genre genre : b.getGenres()) {
			if (genre.getBooks() == null)
				genre.setBooks(new ArrayList<>());
			genre.getBooks().add(b);
			genres.add(genre);
		}
		Author author = b.getAuthor();
		if (author.getBooks() == null)
			author.setBooks(new ArrayList<>());
		author.getBooks().add(b);
		b.setGenres(genres);
		b.setAuthor(author);
		return bookRepository.save(b);
	}

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book getBook(int id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public Book updateBook(int id, Book b) {
		Book book = bookRepository.findById(id).get();
		if (!b.getAuthor().equals(""))
			book.setAuthor(b.getAuthor());
		if (b.getGenres() != null)
			b.setGenres(b.getGenres());
		if (!b.getName().equals(""))
			book.setName(b.getName());
		if (b.getPrice() != 0)
			book.setPrice(b.getPrice());
		return addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
		return;
	}

}
