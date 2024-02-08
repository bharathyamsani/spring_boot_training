package com.example.pcspringboot.service;

import java.util.List;

import com.example.pcspringboot.dto.CategoryDto;
import com.example.pcspringboot.model.Category;

public interface CategoryService {

	Category addCategory(Category c);

	List<CategoryDto> getAllCategories();

	CategoryDto getCategory(long id);

	Category updateCategory(long id, Category c);

	void deleteCategory(long id);

}
