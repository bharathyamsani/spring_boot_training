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

import com.example.springmanytomany.model.Genre;
import com.example.springmanytomany.service.GenreService;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

	@Autowired
	private GenreService genreService;

	@PostMapping
	public Genre addGenre(@RequestBody Genre genre) {
		return genreService.addGenre(genre);
	}

	@GetMapping
	public List<Genre> getAllGenres() {
		return genreService.getGenres();
	}

	@GetMapping("{id}")
	public Genre getGenre(@PathVariable(name = "id") int id) {
		return genreService.getGenre(id);
	}

	@PutMapping("{id}")
	public Genre updateGenre(@PathVariable(name = "id") int id, @RequestBody Genre genre) {
		return genreService.updateGenre(id, genre);
	}

	@DeleteMapping("{id}")
	public String updateGenre(@PathVariable(name = "id") int id) {
		genreService.deleteGenre(id);
		return "Genre with id:" + id + " deleted.";
	}

}
