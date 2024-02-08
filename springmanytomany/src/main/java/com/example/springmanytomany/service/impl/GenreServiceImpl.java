package com.example.springmanytomany.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springmanytomany.model.Book;
import com.example.springmanytomany.model.Genre;
import com.example.springmanytomany.repository.GenreRepository;
import com.example.springmanytomany.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Genre addGenre(Genre g) {
		List<Book> books = new ArrayList<>();
		for (Book b : g.getBooks()) {
			if (b.getAuthor().getBooks() == null)
				b.getAuthor().setBooks(new ArrayList<>());
			if (b.getGenres() == null)
				b.setGenres(new ArrayList<>());
			b.getGenres().add(g);
			b.setAuthor(b.getAuthor());
			books.add(b);
		}
		g.setBooks(books);
		return genreRepository.save(g);
	}

	@Override
	public List<Genre> getGenres() {

		return genreRepository.findAll();
	}

	@Override
	public Genre getGenre(int id) {
		Optional<Genre> genre = genreRepository.findById(id);
		if (genre.isPresent())
			return genre.get();
		return null;
	}

	@Override
	public Genre updateGenre(int id, Genre g) {
		Genre genre = genreRepository.findById(id).get();
		if (g.getBooks() != null)
			genre.setBooks(g.getBooks());
		if (!g.getName().equals(""))
			genre.setName(g.getName());
		return genreRepository.save(genre);
	}

	@Override
	public void deleteGenre(int id) {
		genreRepository.deleteById(id);
	}

}
