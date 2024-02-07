package com.example.pcspringboot.controller;

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

import com.example.pcspringboot.model.Category;
import com.example.pcspringboot.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Category addProduct(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@GetMapping
	public List<Category> getAllProducts() {
		return categoryService.getAllCategories();
	}

	@GetMapping("{id}")
	public Category getCategory(@PathVariable long id) {
		return categoryService.getCategory(id);
	}

	@PutMapping("{id}")
	public Category updateProduct(@PathVariable long id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("{id}")
	public String deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
		return "Record Deleted Successfully";
	}

}
