package com.example.springmanytomany.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmanytomany.model.Author;
import com.example.springmanytomany.model.Book;
import com.example.springmanytomany.model.Genre;
import com.example.springmanytomany.repository.AuthorRepository;
import com.example.springmanytomany.repository.BookRepository;
import com.example.springmanytomany.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Author addAuthor(Author a) {
		List<Book> books = new ArrayList<>();
		for (Book b : a.getBooks()) {
			List<Genre> genres = new ArrayList<>();
			for (Genre g : b.getGenres()) {
				if (g.getBooks() == null)
					g.setBooks(new ArrayList<>());
				g.getBooks().add(b);
				genres.add(g);
			}
			b.setAuthor(a);
			b.setGenres(genres);
			books.add(b);
		}
		a.setBooks(books);
		return authorRepository.save(a);
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthor(int id) {
		return authorRepository.findById(id).get();
	}

	@Override
	public Author updateAuthor(int id, Author a) {
		Optional<Author> author = authorRepository.findById(id);
		if (author.isPresent()) {
			if (a.getBooks() != null) {
				for (Book b : author.get().getBooks())
					bookRepository.deleteById(b.getBookId());
				author.get().setBooks(new ArrayList<>());
				List<Book> books = new ArrayList<>();
				for (Book b : a.getBooks()) {
					List<Genre> genres = new ArrayList<>();
					for (Genre g : b.getGenres()) {
						if (g.getBooks() == null)
							g.setBooks(new ArrayList<>());
						g.getBooks().add(b);
						genres.add(g);
					}
					b.setGenres(genres);
					b.setAuthor(author.get());
					books.add(b);
				}
				author.get().setBooks(books);
			}
			if (!a.getName().equals(""))
				author.get().setName(a.getName());
		}
		return authorRepository.save(author.get());
	}

	@Override
	public void deleteAuthor(int id) {
		authorRepository.deleteById(id);
		return;

	}

}
