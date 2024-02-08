package com.example.springmanytomany.service;

import java.util.List;

import com.example.springmanytomany.model.Genre;

public interface GenreService {
	Genre addGenre(Genre g);

	List<Genre> getGenres();

	Genre getGenre(int id);

	Genre updateGenre(int id, Genre g);

	void deleteGenre(int id);
}
