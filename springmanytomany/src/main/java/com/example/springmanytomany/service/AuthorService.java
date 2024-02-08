package com.example.springmanytomany.service;

import java.util.List;

import com.example.springmanytomany.model.Author;

public interface AuthorService {
	Author addAuthor(Author a);

	List<Author> getAuthors();

	Author getAuthor(int id);

	Author updateAuthor(int id, Author a);

	void deleteAuthor(int id);

}
