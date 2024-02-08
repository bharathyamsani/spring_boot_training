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

import com.example.springmanytomany.model.Author;
import com.example.springmanytomany.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping
	public Author addAuthor(@RequestBody Author Author) {
		return authorService.addAuthor(Author);
	}

	@GetMapping
	public List<Author> getAllAuthors() {
		return authorService.getAuthors();
	}

	@GetMapping("{id}")
	public Author getAuthor(@PathVariable(name = "id") int id) {
		return authorService.getAuthor(id);
	}

	@PutMapping("{id}")
	public Author updateAuthor(@PathVariable(name = "id") int id, @RequestBody Author author) {
		return authorService.updateAuthor(id, author);
	}

	@DeleteMapping("{id}")
	public String deleteAuthor(@PathVariable(name = "id") int id) {
		authorService.deleteAuthor(id);
		return "Author with id:" + id + " deleted.";
	}

}